package com.kimwash.practicalwaytouseapi.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://172.30.1.14:4000/"

object RetrofitInstance {
    private val client = OkHttpClient.Builder()
        .addNetworkInterceptor(ResponseInterceptor()) // Response Wrapper를 벗겨내는 Interceptor
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val service : RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}