package com.inspirecoding.mlchallenge.data.remote.model.shipping

data class ShippingResponse(
    val benefits: Any,
    val free_shipping: Boolean,
    val logistic_type: String,
    val mode: String,
    val promise: Any,
    val shipping_score: Int,
    val store_pick_up: Boolean,
    val tags: List<String>
)