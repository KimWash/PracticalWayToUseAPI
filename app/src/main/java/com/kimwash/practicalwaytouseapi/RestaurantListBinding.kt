package com.kimwash.practicalwaytouseapi

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object RestaurantListBinding {
    @JvmStatic
    @BindingAdapter("restaurantState")
    fun RecyclerView.bindData(uiState: RestaurantUiState?) {
        if (uiState != null)
            if (!uiState.loading && uiState.data != null) {
                val a = adapter as RestaurantAdapter
                // 리스트에 추가하고
                val start = a.itemCount
                a.dataSet.addAll(uiState.data.subList(start, uiState.data.size))
                // 추가됐다고 알려주기!
                a.notifyItemRangeInserted(start, uiState.data.size - start)
            }
    }

    @JvmStatic
    @BindingAdapter("restaurantState")
    fun TextView.bindData(uiState: RestaurantUiState?) {
        if (uiState != null) {
            visibility = if (uiState.loading) { // 로딩중
                View.GONE
            } else {
                View.VISIBLE
            }
            text = if (uiState.errorMessage != null) { // 에러 발생
                uiState.errorMessage
            } else { // 빈 데이터
                "더이상 데이터가 없어요!"
            }
        }
    }
}