package com.inspirecoding.mlchallenge.data.remote.model.value

import com.google.gson.annotations.SerializedName

data class ValueResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("results")
    val results: Int? = null
)