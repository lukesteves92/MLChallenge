package com.inspirecoding.mlchallenge.domain.model.shipping

data class ShippingDomain(
    val benefits: Any,
    val free_shipping: Boolean,
    val logistic_type: String,
    val mode: String,
    val promise: Any,
    val shipping_score: Int,
    val store_pick_up: Boolean,
    val tags: List<String>
)