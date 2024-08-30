package com.inspirecoding.mlchallenge.data.remote.model.product

import com.google.gson.annotations.SerializedName

data class ProductInfoResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("score")
    val score: Int? = null,
    @SerializedName("status")
    val status: String? = null
)