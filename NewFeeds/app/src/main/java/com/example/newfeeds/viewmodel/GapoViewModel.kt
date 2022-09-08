package com.example.newfeeds.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.newfeeds.detailmodel.DetailModel
import com.example.newfeeds.model.NewFeedsModel
import com.example.newfeeds.repository.GetData
import io.reactivex.disposables.CompositeDisposable

class GapoViewModel() : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val getNewsRepository = GetData(compositeDisposable)

    private var _news = MediatorLiveData<NewFeedsModel>()
    val news: LiveData<NewFeedsModel> get() = _news


    private var _detail = MediatorLiveData<DetailModel>()
    val detail: LiveData<DetailModel> get() = _detail

    fun abc() {
        _news.addSource(getNewsRepository.getNews()) {
            _news.value = it
        }
    }

    fun xyz() {
        _detail.addSource(getNewsRepository.getDetail()) {
            _detail.value = it
        }
    }
}