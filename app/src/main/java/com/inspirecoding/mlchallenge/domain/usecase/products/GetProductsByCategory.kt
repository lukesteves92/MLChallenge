package com.inspirecoding.mlchallenge.domain.usecase.products

import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetProductsByCategory(
    private val repository: ProductsRepository
) {
    fun getProductsByCategory(category: String): Flow<ProductsDomain> = repository.getProductsByCategory(category = category)
}