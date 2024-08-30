package com.inspirecoding.mlchallenge.data.remote.model.installments

data class InstallmentsResponse(
    val amount: Double,
    val currency_id: String,
    val quantity: Int,
    val rate: Double
)