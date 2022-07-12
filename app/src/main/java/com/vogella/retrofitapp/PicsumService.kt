package com.vogella.retrofitapp

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface PicsumService {

    @GET("/v2/list")
    fun getPhotosAsync(): Deferred<Response<Photos>>

}