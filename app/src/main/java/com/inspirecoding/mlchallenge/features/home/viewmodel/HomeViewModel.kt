package com.inspirecoding.mlchallenge.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.mlchallenge.data.utils.singleorthrow.singleOrThrow
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.usecase.categories.GetCategories
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.features.home.action.HomeAction
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getProductsByCategory: GetProductsByCategory,
    private val getCategories: GetCategories
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<HomeAction>()

    private var _state: MutableStateFlow<HomeState> =
        MutableStateFlow(HomeState.ShowLoading)
    var state: StateFlow<HomeState> = _state

    init {
        handleActions()
        requestCategories(firstCall = true)
    }

    private fun handleActions() {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is HomeAction.GetCategories -> requestCategories(
                        firstCall = false,
                        selectedCategory = action.category
                    )
                }
            }
        }
    }

    fun submitAction(action: HomeAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    private fun requestCategories(
        apiError: Boolean = false,
        firstCall: Boolean,
        selectedCategory: String = EMPTY_STRING_DEFAULT
    ) {
        if (!firstCall) {
            HomeState.ShowLoading.updateState()
        }
        viewModelScope.launch {
            getCategories.getCategories().singleOrThrow(
                success = { listCategory ->
                    requestProductsByCategory(
                        apiError = apiError,
                        categoryList = listCategory,
                        firstCall = firstCall,
                        selectedCategory = checkSelectedCategory(
                            categoryList = listCategory,
                            firstCall = firstCall,
                            selectedCategory = selectedCategory,
                            apiError = apiError
                        )
                    )
                },
                error = {
                    HomeState.UpdateErrorView.updateState()
                }
            )
        }
    }

    private fun requestProductsByCategory(
        apiError: Boolean,
        categoryList: List<CategoriesDomainItem>,
        firstCall: Boolean,
        selectedCategory: String
    ) {
        viewModelScope.launch {
            getProductsByCategory.getProductsByCategory(
                category = checkSelectedCategory(
                    categoryList = categoryList,
                    firstCall = firstCall,
                    selectedCategory = selectedCategory,
                    apiError = apiError
                )
            ).singleOrThrow(
                success = { result ->
                    HomeState.UpdateHomeView(
                        categoryList = categoryList,
                        productList = result.resultResponses ?: listOf(),
                        selectedCategory = selectedCategory
                    ).updateState()
                },
                error = {}
            )
        }
    }

    private fun checkSelectedCategory(
        apiError: Boolean,
        categoryList: List<CategoriesDomainItem>,
        firstCall: Boolean,
        selectedCategory: String
    ): String =
        when (firstCall || apiError) {
            true -> categoryList.first().id.orEmpty()
            else -> selectedCategory
        }

    private fun HomeState.updateState() = _state.update { this }
}