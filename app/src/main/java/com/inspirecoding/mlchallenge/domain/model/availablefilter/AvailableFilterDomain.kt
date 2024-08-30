package com.inspirecoding.mlchallenge.domain.model.availablefilter

import com.inspirecoding.mlchallenge.domain.model.value.ValueDomain

data class AvailableFilterDomain(
    val id: String,
    val name: String,
    val type: String,
    val valueRespons: List<ValueDomain>
)