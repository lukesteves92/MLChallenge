package com.inspirecoding.mlchallenge.domain.model.filter

import com.inspirecoding.mlchallenge.domain.model.value.ValueXDomain

data class FilterDomain(
    val id: String,
    val name: String,
    val type: String,
    val values: List<ValueXDomain>
)