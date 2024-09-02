package com.inspirecoding.mlchallenge.features.home.view

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import com.inspirecoding.mlchallenge.ui.components.product.ProductItem
import com.inspirecoding.mlchallenge.ui.components.toolbar.SearchToolbar
import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val state by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = HomeState.ShowLoading(condition = true))

    Home(state = state, viewModel = viewModel)
}

@Composable
fun Home(
    state: HomeState,
    viewModel: HomeViewModel
) {

    val text = remember { mutableStateOf(EMPTY_STRING_DEFAULT) }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher


    SearchToolbar(
        searchText = text.value,
        goBack = false,
        onSearchClick = {
            if (text.value.isNotEmpty()) {

            }
        },
        onNavigateUpClick = {
            dispatcher?.onBackPressed()
        },
        contentBottom = {

        },
        onTextChanged = {
            text.value = it
        },
        content = {
            ProductItem(
                imageRes = R.drawable.ml_challenge_ic_search, // Substitua pelo recurso de imagem correto
                title = "Bacon Born Brinquedo Gato Pendurado",
                price = "R$ 29,99",
                onDetailsClick = {
                    // Ação ao clicar no botão "Detalhes"
                }
            )
        }
    )
}