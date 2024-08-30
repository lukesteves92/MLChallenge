package com.inspirecoding.mlchallenge.data.remote.model.metadata

import com.google.gson.annotations.SerializedName

data class MetadataResponse(
    @SerializedName("campaign_discount_percentage")
    val campaignDiscountPercentage: Double? = null,
    @SerializedName("campaign_end_date")
    val campaignEndDate: String? = null,
    @SerializedName("campaign_id")
    val campaignId: String? = null,
    @SerializedName("discount_meli_amount")
    val discountAmount: Double? = null,
    @SerializedName("experiment_id")
    val experimentId: String? = null,
    @SerializedName("funding_mode")
    val fundingMode: String? = null,
    @SerializedName("order_item_price")
    val orderItemPrice: Double? = null,
    @SerializedName("promotion_id")
    val promotionId: String? = null,
    @SerializedName("promotion_type")
    val promotionType: String? = null,
    @SerializedName("variation")
    val variation: String? = null
)