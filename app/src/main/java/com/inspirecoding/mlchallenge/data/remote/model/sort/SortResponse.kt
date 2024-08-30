package com.inspirecoding.mlchallenge.data.remote.model.sort

import com.google.gson.annotations.SerializedName

data class SortResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)