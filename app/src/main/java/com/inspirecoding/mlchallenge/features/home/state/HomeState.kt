package com.inspirecoding.mlchallenge.features.home.state

import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain

sealed interface HomeState {
    data class ShowLoading(
        val condition: Boolean
    ) : HomeState

    data class UpdateHomeView(
        val categoryList: List<CategoriesDomainItem>,
        val productList: List<ResultDomain>
    ) : HomeState
}
