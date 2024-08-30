package com.inspirecoding.mlchallenge.data.remote.model.installments

import com.google.gson.annotations.SerializedName

data class InstallmentsResponse(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("currency_id")
    val currencyId: String? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("rate")
    val rate: Double? = null
)