package com.inspirecoding.mlchallenge.features.search.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.inspirecoding.mlchallenge.R
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.extensions.string.formatToARS
import com.inspirecoding.mlchallenge.extensions.string.imageToSecureProtocol
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.search.action.SearchAction
import com.inspirecoding.mlchallenge.features.search.navigation.SearchNavigation
import com.inspirecoding.mlchallenge.features.search.state.SearchState
import com.inspirecoding.mlchallenge.features.search.viewmodel.SearchViewModel
import com.inspirecoding.mlchallenge.ui.components.apierror.ApiErrorScreen
import com.inspirecoding.mlchallenge.ui.components.bottomsheet.main.SheetLayout
import com.inspirecoding.mlchallenge.ui.components.loading.Loading
import com.inspirecoding.mlchallenge.ui.components.product.ProductItem
import com.inspirecoding.mlchallenge.ui.components.toolbar.SearchToolbar
import com.inspirecoding.mlchallenge.utils.Constants.Numbers.KEY_DURATION_ANIMATION
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.inject

@Composable
fun SearchScreen(
    searchText: String?,
    viewModel: SearchViewModel = getViewModel()
) {
    val state by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = SearchState.ShowLoading)

    Search(searchText = searchText.orEmpty(), state = state) { action ->
        viewModel.submitAction(action = action)
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Search(
    searchText: String,
    state: SearchState,
    action: (SearchAction) -> Unit
) {
    action(SearchAction.GetSearch(searchText = searchText, firstCall = true))

    val animationSpec = remember {
        Animatable(0f)
            .run {
                TweenSpec<Float>(durationMillis = KEY_DURATION_ANIMATION)
            }
    }
    val modalState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { false },
        skipHalfExpanded = true,
        animationSpec = animationSpec
    )
    val coroutineScope = rememberCoroutineScope()
    val product = rememberSaveable { mutableStateOf(ResultDomain()) }
    val text = remember { mutableStateOf(searchText) }
    val navigation: SearchNavigation by inject()

    ModalBottomSheetLayout(
        sheetState = modalState,
        sheetContent = {
            SheetLayout(
                product = product.value,
                onCloseBottomSheet = {
                    coroutineScope.launch {
                        modalState.hide()
                    }
                }
            )
        }
    ) {
        SearchToolbar(
            searchToolbarText = stringResource(id = R.string.ml_challenge_search_toolbar),
            searchText = text.value,
            goBack = false,
            onSearchClick = {
                if (text.value.isNotEmpty()) {
                    action(SearchAction.GetSearch(searchText = text.value, firstCall = false))
                }
            },
            onNavigateUpClick = {
                navigation.popBackStack()
            },
            contentBottom = {},
            onTextChanged = {
                text.value = it
            },
            content = {
                when (state) {
                    is SearchState.ShowLoading -> {
                        Loading()
                    }

                    is SearchState.UpdateErrorView -> ApiErrorScreen {
                        action(SearchAction.GetSearch(searchText = text.value, firstCall = false))
                    }

                    is SearchState.UpdateSearchView -> {
                        LazyColumn(
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            items(state.productList) { item ->
                                ProductItem(
                                    imageRes = item.thumbnail.imageToSecureProtocol(),
                                    title = item.title.orEmpty(),
                                    price = item.price.formatToARS(),
                                    onDetailsClick = {
                                        product.value = item
                                        coroutineScope.launch {
                                            modalState.show()
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        )
    }
}