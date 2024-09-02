package com.inspirecoding.mlchallenge.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.mlchallenge.data.utils.singleorthrow.singleOrThrow
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.usecase.categories.GetCategories
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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
                    requestProductsByCategory(categoryList = listCategory)
                },
                error = {}
            )
        }
    }

    private fun requestProductsByCategory(categoryList: List<CategoriesDomainItem>) {
        viewModelScope.launch {
            getProductsByCategory.getProductsByCategory(category = categoryList.first().id.orEmpty()).singleOrThrow(
                success = { result ->
                    HomeState.UpdateHomeView(categoryList = categoryList, productList = result.resultResponses ?: listOf()).updateState()
                },
                error = {}
            )
        }
    }

    private fun HomeState.updateState() = _state.update { this }
}