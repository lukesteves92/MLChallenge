package com.inspirecoding.mlchallenge.data.remote.services.service

import com.inspirecoding.mlchallenge.data.remote.model.categories.CategoriesResponseItem
import com.inspirecoding.mlchallenge.data.remote.model.product.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MLChallengeService {
    @GET(KEY_ENDPOINT_DEFAULT)
    suspend fun getProductsByCategory(
        @Query("category") category: String? = null,
    ): Response<ProductsResponse>

    @GET(KEY_ENDPOINT_DEFAULT)
    suspend fun getProductsBySearch(
        @Query("q") search: String? = null,
    ): Response<ProductsResponse>

    @GET(KEY_ENDPOINT_DEFAULT_CATEGORIES)
    suspend fun getCategories(): Response<List<CategoriesResponseItem>>

    companion object {
        private const val KEY_ENDPOINT_DEFAULT = "/sites/MLA/search"
        private const val KEY_ENDPOINT_DEFAULT_CATEGORIES = "/sites/MLA/categories"
    }
}