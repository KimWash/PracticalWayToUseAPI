package com.kimwash.practicalwaytouseapi.networking.model

data class Restaurant(
    val id: String,
    val name: String,
    val address: String,
    val rate: Double,
    val reviews: List<Review>
    )