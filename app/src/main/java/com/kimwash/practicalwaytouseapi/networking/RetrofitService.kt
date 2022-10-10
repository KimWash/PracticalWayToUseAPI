package com.kimwash.practicalwaytouseapi.networking

import com.kimwash.practicalwaytouseapi.networking.model.ResponseWrapper
import com.kimwash.practicalwaytouseapi.networking.model.Restaurant
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    /**
     * API only lookup
     */
    @GET("restaurant")
    suspend fun fetchRestaurantList() : ResponseWrapper<List<Restaurant>>

    /**
     * API mutates server data
     */
    @POST("restaurant/comments")
    suspend fun writeComment() : ResponseWrapper<Nothing>
}