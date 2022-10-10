package com.kimwash.practicalwaytouseapi.networking.model

data class ResponseWrapper<T>(
    val responseCode: String,
    val data: T? = null,
    val responseMessage: String? = null,
)