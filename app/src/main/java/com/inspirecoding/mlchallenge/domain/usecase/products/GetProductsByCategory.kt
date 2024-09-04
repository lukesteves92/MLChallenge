package com.inspirecoding.mlchallenge.domain.usecase.products

import com.inspirecoding.mlchallenge.domain.model.product.ProductsDomain
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import com.inspirecoding.mlchallenge.extensions.string.formatToARS
import com.inspirecoding.mlchallenge.extensions.string.imageToSecureProtocol
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetProductsByCategory(
    private val repository: ProductsRepository
) {
    fun getProductsByCategory(category: String): Flow<ProductsDomain> {
        return repository.getProductsByCategory(category = category)
            .map { productsDomain ->
                productsDomain.copy(
                    resultResponses = productsDomain.resultResponses?.map { resultResponse ->
                        resultResponse.copy(
                            thumbnail = resultResponse.thumbnail.imageToSecureProtocol(),
                            price = resultResponse.price.formatToARS()
                        )
                    }
                )
            }
    }
}