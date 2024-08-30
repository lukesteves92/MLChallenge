package com.inspirecoding.mlchallenge.data.remote.model.value

import com.inspirecoding.mlchallenge.data.remote.model.struct.StructResponse

data class ValueXXResponse(
    val id: String,
    val name: String,
    val source: Long,
    val structResponse: StructResponse
)