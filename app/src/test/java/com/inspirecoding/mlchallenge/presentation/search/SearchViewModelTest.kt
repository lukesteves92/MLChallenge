package com.inspirecoding.mlchallenge.presentation.search

import com.inspirecoding.mlchallenge.data.utils.exception.MLChallengeException
import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.domain.usecase.search.GetProductsBySearch
import com.inspirecoding.mlchallenge.features.search.action.SearchAction
import com.inspirecoding.mlchallenge.features.search.state.SearchState
import com.inspirecoding.mlchallenge.features.search.viewmodel.SearchViewModel
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
class SearchViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: SearchViewModel
    private val getProductsBySearch: GetProductsBySearch = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = SearchViewModel(getProductsBySearch)
    }

    @Test
    fun `submitAction should emit SearchAction and update state accordingly`() =
        runTest {
            val searchText = "example"
            val firstCall = true
            val mockResult = listOf(ResultDomain())
            val mockResponse = ProductsDomain(resultResponses = mockResult)


            coEvery {
                getProductsBySearch.getSearchProducts(searchText)
            } returns flowOf(mockResponse)

            viewModel.submitAction(SearchAction.GetSearch(searchText, firstCall))

            val state = viewModel.state.first()
            assert(state is SearchState.UpdateSearchView)
            assert((state as SearchState.UpdateSearchView).productList == mockResult)
        }

    @Test
    fun `requestSearch should handle error correctly`() = runTest {
        val searchText = "example"
        val firstCall = true

        coEvery {
            getProductsBySearch.getSearchProducts(searchText)
        } returns flow {
            throw MLChallengeException.ErrorNetworkException
        }

        viewModel.submitAction(SearchAction.GetSearch(searchText, firstCall))

        val state = viewModel.state.first()
        assert(state is SearchState.UpdateErrorView)
    }

    @Test
    fun `requestSearch should show loading state when not first call`() =
        runTest {
            val searchText = "example"
            val firstCall = false
            val mockResult = listOf(ResultDomain())
            val mockResponse = ProductsDomain(resultResponses = mockResult)

            coEvery {
                getProductsBySearch.getSearchProducts(searchText)
            } returns flowOf(mockResponse)

            viewModel.submitAction(SearchAction.GetSearch(searchText, firstCall))

            val state = viewModel.state.first()
            assert(state is SearchState.UpdateSearchView)
            assert((state as SearchState.UpdateSearchView).productList == mockResult)
        }
}