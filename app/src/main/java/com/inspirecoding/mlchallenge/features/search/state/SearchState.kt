package com.inspirecoding.mlchallenge.features.search.state

import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain

sealed interface SearchState {
    data object ShowLoading : SearchState
    data class UpdateSearchView(
        val productList: List<ResultDomain>
    ) : SearchState
    data object UpdateErrorView : SearchState
}