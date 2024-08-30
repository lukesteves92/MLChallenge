package com.inspirecoding.mlchallenge.domain.model.installments

data class InstallmentsDomain(
    val amount: Double,
    val currency_id: String,
    val quantity: Int,
    val rate: Double
)