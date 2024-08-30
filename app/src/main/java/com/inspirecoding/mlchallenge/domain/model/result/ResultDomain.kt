package com.inspirecoding.mlchallenge.domain.model.result

import com.inspirecoding.mlchallenge.domain.model.saleprice.SalePriceDomain
import com.inspirecoding.mlchallenge.domain.model.seller.SellerDomain
import com.inspirecoding.mlchallenge.domain.model.shipping.ShippingDomain
import com.inspirecoding.mlchallenge.domain.model.attribute.AttributeDomain
import com.inspirecoding.mlchallenge.domain.model.differentialpricing.DifferentialPricingDomain
import com.inspirecoding.mlchallenge.domain.model.installments.InstallmentsDomain

data class ResultDomain(
    val accepts_mercadopago: Boolean,
    val attributeRespons: List<AttributeDomain>,
    val available_quantity: Int,
    val buying_mode: String,
    val catalog_listing: Boolean,
    val catalog_product_id: String,
    val category_id: String,
    val condition: String,
    val currency_id: String,
    val differential_pricing: DifferentialPricingDomain,
    val discounts: Any,
    val domain_id: String,
    val id: String,
    val installmentsDomain: InstallmentsDomain,
    val inventory_id: String,
    val listing_type_id: String,
    val official_store_id: Int,
    val official_store_name: String,
    val order_backend: Int,
    val original_price: Double,
    val permalink: String,
    val price: Double,
    val promotions: List<Any>,
    val sale_price: SalePriceDomain,
    val sanitized_title: String,
    val sellerDomain: SellerDomain,
    val shippingDomain: ShippingDomain,
    val site_id: String,
    val stop_time: String,
    val thumbnail: String,
    val thumbnail_id: String,
    val title: String,
    val use_thumbnail_id: Boolean,
    val winner_item_id: Any
)