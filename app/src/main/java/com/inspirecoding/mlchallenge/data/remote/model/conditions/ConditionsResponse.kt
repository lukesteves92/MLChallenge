package com.inspirecoding.mlchallenge.data.remote.model.conditions

data class ConditionsResponse(
    val context_restrictions: List<String>,
    val eligible: Boolean,
    val end_time: String,
    val start_time: String
)