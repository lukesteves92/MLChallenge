package com.inspirecoding.mlchallenge.domain.usecase.categories

import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow

class GetCategories (
    private val repository: ProductsRepository
) {
    fun getCategories(): Flow<List<CategoriesDomainItem>> = repository.getCategories()
}