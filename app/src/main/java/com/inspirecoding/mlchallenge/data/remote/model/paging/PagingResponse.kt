package com.inspirecoding.mlchallenge.data.remote.model.paging

data class PagingResponse(
    val limit: Int,
    val offset: Int,
    val primary_results: Int,
    val total: Int
)