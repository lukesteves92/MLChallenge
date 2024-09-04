package com.inspirecoding.mlchallenge.features.home.view

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.extensions.features.rememberFlowWithLifecycle
import com.inspirecoding.mlchallenge.extensions.string.formatToARS
import com.inspirecoding.mlchallenge.extensions.string.imageToSecureProtocol
import com.inspirecoding.mlchallenge.features.home.action.HomeAction
import com.inspirecoding.mlchallenge.features.home.navigation.HomeNavigation
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import com.inspirecoding.mlchallenge.ui.components.apierror.ApiErrorScreen
import com.inspirecoding.mlchallenge.ui.components.bottomsheet.main.SheetLayout
import com.inspirecoding.mlchallenge.ui.components.chip.ChipGroup
import com.inspirecoding.mlchallenge.ui.components.loading.Loading
import com.inspirecoding.mlchallenge.ui.components.product.ProductItem
import com.inspirecoding.mlchallenge.ui.components.toolbar.SearchToolbar
import com.inspirecoding.mlchallenge.utils.Constants.Numbers.KEY_DURATION_ANIMATION
import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.inject

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = getViewModel()
) {
    val state by rememberFlowWithLifecycle(viewModel.state)
        .collectAsState(initial = HomeState.ShowLoading)

    Home(state = state) { action ->
        viewModel.submitAction(action = action)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(
    state: HomeState,
    action: (HomeAction) -> Unit
) {

    val product = rememberSaveable { mutableStateOf(ResultDomain()) }
    val text = remember { mutableStateOf(EMPTY_STRING_DEFAULT) }
    val dispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

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
    val navigation: HomeNavigation by inject()

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
            searchText = text.value,
            goBack = false,
            onSearchClick = {
                if (text.value.isNotEmpty()) {
                    navigation.navigateToSearch(searchText = text.value)
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
                when (state) {
                    is HomeState.ShowLoading -> {
                        Loading()
                    }

                    is HomeState.UpdateErrorView -> ApiErrorScreen {
                        action(HomeAction.GetCategories(category = EMPTY_STRING_DEFAULT))
                    }

                    is HomeState.UpdateHomeView -> {
                        ChipGroup(
                            modifier = Modifier.padding(vertical = 16.dp),
                            category = state.selectedCategory,
                            list = state.categoryList,
                            onSelectionChanged = { category ->
                                action(HomeAction.GetCategories(category = category.id.orEmpty()))
                            }
                        )

                        LazyColumn(
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            items(state.productList) { item ->
                                ProductItem(
                                    imageRes = item.thumbnail,
                                    title = item.title.orEmpty(),
                                    price = item.price.orEmpty(),
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