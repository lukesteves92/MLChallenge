package com.inspirecoding.mlchallenge.data.repository

import com.inspirecoding.mlchallenge.data.remote.mapper.toDomain
import com.inspirecoding.mlchallenge.data.remote.services.responseapi.ResponseApi
import com.inspirecoding.mlchallenge.data.remote.services.service.MLChallengeService
import com.inspirecoding.mlchallenge.data.remote.services.wrapper.RequestWrapper
import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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
    }

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
    }
}