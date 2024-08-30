package com.inspirecoding.mlchallenge.domain.model.pdp

import com.inspirecoding.mlchallenge.domain.model.product.ProductInfoDomain

data class PdpTrackingDomain(
    val group: Boolean,
    val product_info: List<ProductInfoDomain>
)