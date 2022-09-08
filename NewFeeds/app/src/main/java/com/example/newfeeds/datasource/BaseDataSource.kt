package com.example.newfeeds.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newfeeds.NetworkState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseDataSource(protected val compositeDisposable: CompositeDisposable) {
    protected val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState
}