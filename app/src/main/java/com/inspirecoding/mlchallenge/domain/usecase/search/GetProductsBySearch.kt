package com.inspirecoding.mlchallenge.domain.usecase.search

import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsBySearch(
    private val repository: ProductsRepository
) {
    fun getSearchProducts(search: String): Flow<ProductsDomain> = repository.getProductsBySearch(search = search)
}