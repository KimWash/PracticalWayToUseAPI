package com.kimwash.practicalwaytouseapi.networking

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val BASE_URL = "http://192.168.0.100:3000/api"

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