package com.inspirecoding.mlchallenge.domain.model.saleprice

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.conditions.ConditionsDomain
import com.inspirecoding.mlchallenge.domain.model.metadata.MetadataDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class SalePriceDomain(
    val amount: Double? = null,
    val conditionsDomain: ConditionsDomain? = null,
    val currencyId: String? = null,
    val exchangeRate: @RawValue Any? = null,
    val metadataDomain: MetadataDomain? = null,
    val paymentMethodPrices: @RawValue List<Any>? = null,
    val paymentMethodType: String? = null,
    val priceId: String? = null,
    val regularAmount: Double? = null,
    val type: String? = null
) : Parcelable