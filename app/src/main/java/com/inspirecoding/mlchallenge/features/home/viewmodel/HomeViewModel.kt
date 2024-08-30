package com.inspirecoding.mlchallenge.features.home.viewmodel

import androidx.lifecycle.ViewModel
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(
    private val getProductsByCategory: GetProductsByCategory
) : ViewModel() {
    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.ShowLoading(condition = false))
    var state: StateFlow<HomeState> = _state

}