package com.example.newfeeds.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newfeeds.NetworkState
import com.example.newfeeds.datasource.BaseDataSource
import com.example.newfeeds.datasource.ResponseParser
import com.example.newfeeds.datasource.RetrofitInstance
import com.example.newfeeds.detailmodel.DetailModel
import com.example.newfeeds.model.NewFeedsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GetData(compositeDisposable: CompositeDisposable) : BaseDataSource(compositeDisposable) {
    private val retrofitService = RetrofitInstance.getRetrofitInstance()

    fun getNews(): LiveData<NewFeedsModel> {
        var result = MutableLiveData<NewFeedsModel>()
        compositeDisposable.add(
            retrofitService.getFeed()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{_networkState.postValue(NetworkState.LOADING)}
                .subscribe({
                    val data =
                        ResponseParser.parseObject(it, NewFeedsModel::class.java)
                    if (data is NewFeedsModel) {
                        result.value = data!!
                        _networkState.value = NetworkState.SUCCESS
                    } else {
                        _networkState.value = NetworkState.ERROR
                    }
                }, {
                    _networkState.value = NetworkState.ERROR
                })
        )
        return result
    }

    fun getDetail(): LiveData<DetailModel> {
        var result = MutableLiveData<DetailModel>()
        compositeDisposable.add(
            retrofitService.getDetail()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{_networkState.postValue(NetworkState.LOADING)}
                .subscribe({
                    val data =
                        ResponseParser.parseObject(it, DetailModel::class.java)
                    if (data is DetailModel) {
                        result.value = data!!
                        _networkState.value = NetworkState.SUCCESS
                    } else {
                        _networkState.value = NetworkState.ERROR
                    }
                }, {
                    _networkState.value = NetworkState.ERROR
                })
        )
        return result
    }

}