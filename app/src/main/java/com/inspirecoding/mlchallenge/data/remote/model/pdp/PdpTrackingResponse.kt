package com.inspirecoding.mlchallenge.data.remote.model.pdp

import com.inspirecoding.mlchallenge.data.remote.model.product.ProductInfoResponse

data class PdpTrackingResponse(
    val group: Boolean,
    val product_info: List<ProductInfoResponse>
)