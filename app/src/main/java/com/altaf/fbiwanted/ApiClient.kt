package com.altaf.fbiwanted

import androidx.viewbinding.BuildConfig

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    fun getApiService(): ApiService {
        // utk memuncculkan response dari api di logcat

        val httpLoggingInterceptor: HttpLoggingInterceptor = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }

        // client nya
        val okHttpClient = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor {
                val request = it.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                return@addInterceptor it.proceed(request)
            }

            // utk nge ping internet
            .pingInterval(10, TimeUnit.SECONDS)
            // batas baca jk blm ke load maka akan di beri peringatan eror
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        // setelah itu client akan dipakai di retorfit
        return Retrofit.Builder()
            .baseUrl("https://api.fbi.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

//    companion object{
//        fun getApiService(): ApiService {
//            val loggingInterceptor = if (BuildConfig.DEBUG){
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//            }else{
//                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
//            }
//            val client = OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor)
//                .build()
//            val retrofit = Retrofit.Builder()
//                .baseUrl("https://api.fbi.gov/wanted/v1")
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(client)
//                .build()
//            return retrofit.create(ApiService::class.java)
//        }
//    }
}