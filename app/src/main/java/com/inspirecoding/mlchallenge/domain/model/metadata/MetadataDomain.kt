package com.inspirecoding.mlchallenge.domain.model.metadata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MetadataDomain(
    val campaignDiscountPercentage: Double? = null,
    val campaignEndDate: String? = null,
    val campaignId: String? = null,
    val discountAmount: Double? = null,
    val experimentId: String? = null,
    val fundingMode: String? = null,
    val orderItemPrice: Double? = null,
    val promotionId: String? = null,
    val promotionType: String? = null,
    val variation: String? = null
) : Parcelable