package com.inspirecoding.mlchallenge.features.home.view

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import com.inspirecoding.mlchallenge.navigation.screen.Screen
import com.inspirecoding.mlchallenge.ui.components.chip.ChipGroup
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
            when(state) {
                is HomeState.ShowLoading -> {}
                is HomeState.UpdateHomeView -> {
                    ChipGroup(
                        modifier = Modifier.padding(vertical = 16.dp),
                        category = state.categoryList.first(),
                        list = state.categoryList,
                        onSelectionChanged = {

                        }
                    )

                    LazyColumn(
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(state.productList) { item ->
                            ProductItem(
                                imageRes = item.thumbnail, // Substitua pelo recurso de imagem correto
                                title = item.title.orEmpty(),
                                price = item.price.toString(),
                                onDetailsClick = {
                                    // Ação ao clicar no botão "Detalhes"
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}