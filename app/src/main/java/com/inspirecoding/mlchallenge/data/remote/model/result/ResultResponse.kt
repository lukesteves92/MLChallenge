package com.inspirecoding.mlchallenge.data.remote.model.result

import com.inspirecoding.mlchallenge.data.remote.model.saleprice.SalePriceResponse
import com.inspirecoding.mlchallenge.data.remote.model.seller.SellerResponse
import com.inspirecoding.mlchallenge.data.remote.model.shipping.ShippingResponse
import com.inspirecoding.mlchallenge.data.remote.model.attribute.AttributeResponse
import com.inspirecoding.mlchallenge.data.remote.model.differentialpricing.DifferentialPricingResponse
import com.inspirecoding.mlchallenge.data.remote.model.installments.InstallmentsResponse

data class ResultResponse(
    val accepts_mercadopago: Boolean,
    val attributeResponses: List<AttributeResponse>,
    val available_quantity: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val condition: String,
    val currency_id: String,
    val differential_pricing: DifferentialPricingResponse,
    val discounts: Any,
    val domain_id: String,
    val id: String,
    val installmentsResponse: InstallmentsResponse,
    val inventory_id: String,
    val listing_type_id: String,
    val official_store_id: Int,
    val official_store_name: String,
    val order_backend: Int,
    val original_price: Double,
    val permalink: String,
    val price: Double,
    val promotions: List<Any>,
    val sale_price: SalePriceResponse,
    val sanitized_title: String,
    val sellerResponse: SellerResponse,
    val shippingResponse: ShippingResponse,
    val site_id: String,
    val stop_time: String,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val use_thumbnail_id: Boolean,
    val winner_item_id: Any
)