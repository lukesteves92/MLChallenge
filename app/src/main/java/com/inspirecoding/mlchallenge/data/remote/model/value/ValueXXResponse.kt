package com.inspirecoding.mlchallenge.data.remote.model.value

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.struct.StructResponse

data class ValueXXResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("source")
    val source: Long? = null,
    @SerializedName("structResponse")
    val structResponse: StructResponse? = null
)