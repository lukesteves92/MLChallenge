package com.inspirecoding.mlchallenge.data.remote.model.shipping

import com.google.gson.annotations.SerializedName

data class ShippingResponse(
    @SerializedName("benefits")
    val benefits: Any? = null,
    @SerializedName("free_shipping")
    val freeShipping: Boolean? = null,
    @SerializedName("logistic_type")
    val logisticType: String? = null,
    @SerializedName("mode")
    val mode: String? = null,
    @SerializedName("promise")
    val promise: Any? = null,
    @SerializedName("shipping_score")
    val shippingScore: Int? = null,
    @SerializedName("store_pick_up")
    val storePickUp: Boolean? = null,
    @SerializedName("tags")
    val tags: List<String>? = null
)