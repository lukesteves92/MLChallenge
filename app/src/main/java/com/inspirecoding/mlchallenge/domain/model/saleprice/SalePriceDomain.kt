package com.inspirecoding.mlchallenge.domain.model.saleprice

import com.inspirecoding.mlchallenge.domain.model.conditions.ConditionsDomain
import com.inspirecoding.mlchallenge.domain.model.metadata.MetadataDomain

data class SalePriceDomain(
    val amount: Double,
    val conditionsDomain: ConditionsDomain,
    val currency_id: String,
    val exchange_rate: Any,
    val metadataDomain: MetadataDomain,
    val payment_method_prices: List<Any>,
    val payment_method_type: String,
    val price_id: String,
    val regular_amount: Double,
    val type: String
)