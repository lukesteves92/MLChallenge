package com.inspirecoding.mlchallenge.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.mlchallenge.data.utils.singleorthrow.singleOrThrow
import com.inspirecoding.mlchallenge.domain.usecase.categories.GetCategories
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsByCategory: GetProductsByCategory,
    private val getCategories: GetCategories
) : ViewModel() {
    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.ShowLoading(condition = true))
    var state: StateFlow<HomeState> = _state

    init {
        requestCategories()
    }

    private fun requestCategories() {
        viewModelScope.launch {
            getCategories.getCategories().singleOrThrow(
                success = { listCategory ->
                    requestProductsByCategory(category = listCategory.first().id)
                },
                error = {}
            )
        }
    }

    private fun requestProductsByCategory(category: String) {
        viewModelScope.launch {
            getProductsByCategory.getProductsByCategory(category).singleOrThrow(
                success = { result ->
                    val data = result
                },
                error = {}
            )
        }
    }
}