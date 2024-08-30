package com.inspirecoding.mlchallenge.domain.model.paging

data class PagingDomain(
    val limit: Int,
    val offset: Int,
    val primary_results: Int,
    val total: Int
)