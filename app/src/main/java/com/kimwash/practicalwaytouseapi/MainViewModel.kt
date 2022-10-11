package com.kimwash.practicalwaytouseapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kimwash.practicalwaytouseapi.networking.model.Restaurant
import com.kimwash.practicalwaytouseapi.usecase.GetRestaurantList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class RestaurantUiState(
    val data: List<Restaurant>? = null,
    val loading: Boolean = false,
    val errorMessage: String? = null
)

class MainViewModel : ViewModel() {
    private val _state = MutableStateFlow(RestaurantUiState())
    val state : StateFlow<RestaurantUiState> = _state

    fun getRestaurantList() {
        _state.update {
            it.copy(loading = true)
        }
        viewModelScope.launch {
            kotlin.runCatching {
                GetRestaurantList().run(null)
            }.onSuccess { data ->
                _state.update {
                    it.copy(
                        loading = false,
                        data = data
                    )
                }
            }.onFailure { error ->
                _state.update {
                    it.copy(
                        loading = false,
                        errorMessage = error.message
                    )
                }
            }
        }
    }

    fun writeComment() {

    }
}