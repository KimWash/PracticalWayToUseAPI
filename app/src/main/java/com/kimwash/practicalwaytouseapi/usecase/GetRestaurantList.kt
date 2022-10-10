package com.kimwash.practicalwaytouseapi.usecase

import com.kimwash.practicalwaytouseapi.networking.RetrofitInstance
import com.kimwash.practicalwaytouseapi.networking.model.Restaurant

data class RestaurantFilterParams(val name:String, val startDate: String, val endDate: String)

class GetRestaurantList : UseCase<RestaurantFilterParams?, List<Restaurant>?>() {
    override suspend fun onExecute(params: RestaurantFilterParams?): List<Restaurant>? {
        return RetrofitInstance.service.fetchRestaurantList().data
    }
}