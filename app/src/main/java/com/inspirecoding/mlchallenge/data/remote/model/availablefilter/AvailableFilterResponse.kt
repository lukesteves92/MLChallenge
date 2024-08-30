package com.inspirecoding.mlchallenge.data.remote.model.availablefilter

import com.inspirecoding.mlchallenge.data.remote.model.value.ValueResponse

data class AvailableFilterResponse(
    val id: String,
    val name: String,
    val type: String,
    val valueResponses: List<ValueResponse>
)