package com.inspirecoding.mlchallenge.features.search.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inspirecoding.mlchallenge.data.utils.singleorthrow.singleOrThrow
import com.inspirecoding.mlchallenge.domain.usecase.search.GetProductsBySearch
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.search.action.SearchAction
import com.inspirecoding.mlchallenge.features.search.state.SearchState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getProductsBySearch: GetProductsBySearch
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<SearchAction>()

    private var _state: MutableStateFlow<SearchState> =
        MutableStateFlow(SearchState.ShowLoading)
    var state: StateFlow<SearchState> = _state

    init {
        handleActions()
    }

    private fun handleActions() {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is SearchAction.GetSearch -> requestSearch(
                        searchText = action.searchText,
                        firstCall = action.firstCall
                    )
                }
            }
        }
    }

    fun submitAction(action: SearchAction) {
        viewModelScope.launch {
            pendingActions.emit(action)

        }
    }

    private fun requestSearch(
        searchText: String,
        firstCall: Boolean
    ) {
        if (!firstCall) {
            SearchState.ShowLoading.updateState()
        }
        viewModelScope.launch {
            getProductsBySearch.getSearchProducts(search = searchText)
                .singleOrThrow(
                    success = { result ->
                        SearchState.UpdateSearchView(
                            productList = result.resultResponses ?: listOf(),
                        ).updateState()

                    },
                    error = {
                        SearchState.UpdateErrorView.updateState()
                    }
                )
        }
    }

    private fun SearchState.updateState() = _state.update { this }
}