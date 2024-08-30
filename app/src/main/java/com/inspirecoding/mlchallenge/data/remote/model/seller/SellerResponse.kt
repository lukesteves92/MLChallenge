package com.inspirecoding.mlchallenge.data.remote.model.seller

import com.google.gson.annotations.SerializedName

data class SellerResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("nickname")
    val nickname: String? = null
)