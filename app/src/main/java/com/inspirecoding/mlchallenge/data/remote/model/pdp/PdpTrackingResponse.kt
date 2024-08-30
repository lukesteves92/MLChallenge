package com.inspirecoding.mlchallenge.data.remote.model.pdp

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.product.ProductInfoResponse

data class PdpTrackingResponse(
    @SerializedName("group")
    val group: Boolean? = null,
    @SerializedName("product_info")
    val productInfo: List<ProductInfoResponse>? = null
)