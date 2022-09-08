package com.example.newfeeds.datasource

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface GapoService {
    companion object {
        const val API_NEWS = "feed"
        const val API_DETAIL = "detail"
    }

    @GET(API_NEWS)
    fun getFeed(): Single<Response<ResponseBody>>

    @GET(API_DETAIL)
    fun getDetail(): Single<Response<ResponseBody>>

}