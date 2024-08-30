package com.inspirecoding.mlchallenge.data.remote.model.metadata

data class MetadataResponse(
    val campaign_discount_percentage: Double,
    val campaign_end_date: String,
    val campaign_id: String,
    val discount_meli_amount: Double,
    val experiment_id: String,
    val funding_mode: String,
    val order_item_price: Double,
    val promotion_id: String,
    val promotion_type: String,
    val variation: String
)