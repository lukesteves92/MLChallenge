package com.inspirecoding.mlchallenge.features.home.state

import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.features.search.state.SearchState

sealed interface HomeState {
    data object ShowLoading : HomeState
    data class UpdateHomeView(
        val selectedCategory: String,
        val categoryList: List<CategoriesDomainItem>,
        val productList: List<ResultDomain>
    ) : HomeState
    data object UpdateErrorView : HomeState
}
