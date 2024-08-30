package com.inspirecoding.mlchallenge.data.remote.model.struct

import com.google.gson.annotations.SerializedName

data class StructResponse(
    @SerializedName("number")
    val number: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)