package com.inspirecoding.mlchallenge.data.remote.model.availablesort

import com.google.gson.annotations.SerializedName

data class AvailableSortResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)