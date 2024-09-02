package com.inspirecoding.mlchallenge.presentation.home

import com.inspirecoding.mlchallenge.data.utils.exception.MLChallengeException
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.domain.usecase.categories.GetCategories
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.features.home.action.HomeAction
import com.inspirecoding.mlchallenge.features.home.state.HomeState
import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import com.inspirecoding.mlchallenge.main.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@FlowPreview
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: HomeViewModel
    private val getProductsByCategory: GetProductsByCategory = mockk(relaxed = true)
    private val getCategories: GetCategories = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = HomeViewModel(getProductsByCategory, getCategories)
    }

    @Test
    fun `requestCategories should handle error correctly`() = runTest {
        coEvery { getCategories.getCategories() } returns flow {
            throw MLChallengeException.ErrorNetworkException
        }

        viewModel.submitAction(HomeAction.GetCategories("exampleCategory"))

        val state = viewModel.state.first()
        assert(state is HomeState.UpdateErrorView)
    }

    @Test
    fun `submitAction should emit HomeAction and update state accordingly`() = runTest {
        val category = "exampleCategory"
        val mockCategories = listOf(CategoriesDomainItem(id = "exampleId"))
        val mockProducts = listOf(ResultDomain())
        val mockResponse = ProductsDomain(resultResponses = mockProducts)

        coEvery { getCategories.getCategories() } returns flowOf(mockCategories)
        coEvery { getProductsByCategory.getProductsByCategory(category) } returns flowOf(mockResponse)

        viewModel.submitAction(HomeAction.GetCategories(category))

        val state = viewModel.state.first()
        assert(state is HomeState.UpdateHomeView)
        assert((state as HomeState.UpdateHomeView).productList == mockProducts)
        assert((state).categoryList == mockCategories)
        assert((state).selectedCategory == category)
    }
}