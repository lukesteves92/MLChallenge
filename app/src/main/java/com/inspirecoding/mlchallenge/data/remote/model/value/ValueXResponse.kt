package com.inspirecoding.mlchallenge.data.remote.model.value

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.path.PathFromRootResponse

data class ValueXResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("path_from_root")
    val pathFromRoot: List<PathFromRootResponse>? = null
)