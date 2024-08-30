package com.inspirecoding.mlchallenge.domain.model.exception

data class GenericException(
    val title: String? = null,
    val message: String? = null,
    val code: String? = null
)
