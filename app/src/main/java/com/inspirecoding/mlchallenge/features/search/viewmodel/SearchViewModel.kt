package com.inspirecoding.mlchallenge.features.search.viewmodel

import androidx.lifecycle.ViewModel
import com.inspirecoding.mlchallenge.domain.usecase.search.GetProductsBySearch
import com.inspirecoding.mlchallenge.features.search.state.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel(
    private val getProductsBySearch: GetProductsBySearch
) : ViewModel() {
    private var _state: MutableStateFlow<SearchState> =
        MutableStateFlow(SearchState.ShowLoading(condition = false))
    var state: StateFlow<SearchState> = _state
}