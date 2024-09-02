package com.inspirecoding.mlchallenge.data.repository

import com.inspirecoding.mlchallenge.data.remote.mapper.toDomain
import com.inspirecoding.mlchallenge.data.remote.services.responseapi.ResponseApi
import com.inspirecoding.mlchallenge.data.remote.services.service.MLChallengeService
import com.inspirecoding.mlchallenge.data.remote.services.wrapper.RequestWrapper
import com.inspirecoding.mlchallenge.domain.model.categories.CategoriesDomainItem
import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductsRepositoryImpl(
    private val wrapper: RequestWrapper,
    private val service: MLChallengeService
): ProductsRepository {
    override fun getProductsByCategory(category: String): Flow<ProductsDomain> = flow {
        val result = wrapper.wrapper {
            service.getProductsByCategory(
                category = category
            )
        }
        when (result) {
            is ResponseApi.Success -> emit(result.data?.toDomain() ?: ProductsDomain())

            is ResponseApi.ErrorException -> throw result.errorException
        }
    }.flowOn(Dispatchers.IO)

    override fun getProductsBySearch(search: String): Flow<ProductsDomain> = flow {
        val result = wrapper.wrapper {
            service.getProductsBySearch(
                search = search
            )
        }
        when (result) {
            is ResponseApi.Success -> emit(result.data?.toDomain() ?: ProductsDomain())

            is ResponseApi.ErrorException -> throw result.errorException
        }
    }.flowOn(Dispatchers.IO)

    override fun getCategories(): Flow<List<CategoriesDomainItem>> = flow {
        val result = wrapper.wrapper {
            service.getCategories()
        }
        when (result) {
            is ResponseApi.Success -> emit(result.data?.map { category -> category.toDomain() } ?: listOf())

            is ResponseApi.ErrorException -> throw result.errorException
        }
    }.flowOn(Dispatchers.IO)
}