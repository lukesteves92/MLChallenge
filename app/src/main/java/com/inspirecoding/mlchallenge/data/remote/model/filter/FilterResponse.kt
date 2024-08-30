package com.inspirecoding.mlchallenge.data.remote.model.filter

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXResponse

data class FilterResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("values")
    val values: List<ValueXResponse>? = null
)