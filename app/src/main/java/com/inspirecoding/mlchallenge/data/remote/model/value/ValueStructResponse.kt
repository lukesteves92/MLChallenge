package com.inspirecoding.mlchallenge.data.remote.model.value

import com.google.gson.annotations.SerializedName

data class ValueStructResponse(
    @SerializedName("number")
    val number: Double? = null,
    @SerializedName("unit")
    val unit: String? = null
)