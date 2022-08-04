package com.altaf.fbiwanted

import io.reactivex.rxjava3.core.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
//    @GET("/api/v1/wanted/")
//    fun getWanted(): Call<List<Wanted>>
//
//    @GET("/api/v1/wanted/{id}")
//    fun getWantedById(@Path("id") id: String): Call<Wanted>

//    @GET("list")
//    fun getWanted(): Call<WantedResponse>

    @GET("@wanted")
    fun getWanted(): Flowable<WantedResponse>
}