package com.inspirecoding.mlchallenge.domain.model.value

import com.inspirecoding.mlchallenge.domain.model.struct.StructDomain

data class ValueXXDomain(
    val id: String,
    val name: String,
    val source: Long,
    val structDomain: StructDomain
)