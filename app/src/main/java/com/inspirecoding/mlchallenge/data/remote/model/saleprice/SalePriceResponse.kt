package com.inspirecoding.mlchallenge.data.remote.model.saleprice

import com.inspirecoding.mlchallenge.data.remote.model.conditions.ConditionsResponse
import com.inspirecoding.mlchallenge.data.remote.model.metadata.MetadataResponse

data class SalePriceResponse(
    val amount: Double,
    val conditionsResponse: ConditionsResponse,
    val currency_id: String,
    val exchange_rate: Any,
    val metadataResponse: MetadataResponse,
    val payment_method_prices: List<Any>,
    val payment_method_type: String,
    val price_id: String,
    val regular_amount: Double,
    val type: String
)