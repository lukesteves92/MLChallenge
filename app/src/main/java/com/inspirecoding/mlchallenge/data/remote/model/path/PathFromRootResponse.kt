package com.inspirecoding.mlchallenge.data.remote.model.path

import com.google.gson.annotations.SerializedName

data class PathFromRootResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)