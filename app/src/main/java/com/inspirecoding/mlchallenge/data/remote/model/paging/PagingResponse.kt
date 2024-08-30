package com.inspirecoding.mlchallenge.data.remote.model.paging

import com.google.gson.annotations.SerializedName

data class PagingResponse(
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("primary_results")
    val primaryResults: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)