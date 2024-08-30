package com.inspirecoding.mlchallenge.domain.model.conditions

data class ConditionsDomain(
    val context_restrictions: List<String>,
    val eligible: Boolean,
    val end_time: String,
    val start_time: String
)