package com.inspirecoding.mlchallenge.features.home.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val state by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = HomeState.ShowLoading(condition = false))

    Home(state = state, viewModel = viewModel)
}

@Composable
fun Home(
    state: HomeState,
    viewModel: HomeViewModel
) {

}