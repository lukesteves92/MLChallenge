package com.inspirecoding.mlchallenge.data.remote.model.availablefilter

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueResponse

data class AvailableFilterResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("valueResponses")
    val valueResponses: List<ValueResponse>? = null
)