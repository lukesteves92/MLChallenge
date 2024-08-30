package com.inspirecoding.mlchallenge.data.remote.model.filter

import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXResponse

data class FilterResponse(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValueXResponse>
)