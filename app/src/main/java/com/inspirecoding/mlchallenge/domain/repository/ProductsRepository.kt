package com.inspirecoding.mlchallenge.domain.repository

import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProductsByCategory(category: String): Flow<ProductsDomain>
    fun getProductsBySearch(search: String): Flow<ProductsDomain>
}