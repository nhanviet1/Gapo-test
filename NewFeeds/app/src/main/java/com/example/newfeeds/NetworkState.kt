package com.example.newfeeds

class NetworkState(val status: Status, val message: String?) {
    constructor(status: Status) : this(status, "")

    companion object {
        val LOADING = NetworkState(Status.LOADING)
        val SUCCESS = NetworkState(Status.SUCCESSFUL)
        val ERROR = NetworkState(Status.FAILED)
    }

    enum class Status {
        LOADING,
        SUCCESSFUL,
        FAILED,
        END_OF_LIST
    }
}