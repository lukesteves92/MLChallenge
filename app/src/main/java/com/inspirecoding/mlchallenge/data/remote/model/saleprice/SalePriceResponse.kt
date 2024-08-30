package com.inspirecoding.mlchallenge.data.remote.model.saleprice

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.conditions.ConditionsResponse
import com.inspirecoding.mlchallenge.data.remote.model.metadata.MetadataResponse

data class SalePriceResponse(
    @SerializedName("amount")
    val amount: Double? = null,
    @SerializedName("conditionsResponse")
    val conditionsResponse: ConditionsResponse? = null,
    @SerializedName("currency_id")
    val currencyId: String? = null,
    @SerializedName("exchange_rate")
    val exchangeRate: Any? = null,
    @SerializedName("metadataResponse")
    val metadataResponse: MetadataResponse? = null,
    @SerializedName("payment_method_prices")
    val paymentMethodPrices: List<Any>? = null,
    @SerializedName("payment_method_type")
    val paymentMethodType: String? = null,
    @SerializedName("price_id")
    val priceId: String? = null,
    @SerializedName("regular_amount")
    val regularAmount: Double? = null,
    @SerializedName("type")
    val type: String? = null
)