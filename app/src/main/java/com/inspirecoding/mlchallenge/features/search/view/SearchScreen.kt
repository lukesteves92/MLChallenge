package com.inspirecoding.mlchallenge.features.search.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.features.search.state.SearchState
import com.inspirecoding.mlchallenge.features.search.viewmodel.SearchViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = getViewModel()
) {
    val state by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = SearchState.ShowLoading(condition = false))

    Search(state = state, viewModel = viewModel)
}

@Composable
fun Search(
    state: SearchState,
    viewModel: SearchViewModel
) {

}