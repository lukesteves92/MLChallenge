package com.inspirecoding.mlchallenge.data.remote.model.result

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.saleprice.SalePriceResponse
import com.inspirecoding.mlchallenge.data.remote.model.seller.SellerResponse
import com.inspirecoding.mlchallenge.data.remote.model.shipping.ShippingResponse
import com.inspirecoding.mlchallenge.data.remote.model.attribute.AttributeResponse
import com.inspirecoding.mlchallenge.data.remote.model.differentialpricing.DifferentialPricingResponse
import com.inspirecoding.mlchallenge.data.remote.model.installments.InstallmentsResponse

data class ResultResponse(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadoPago: Boolean? = null,
    @SerializedName("attributeResponses")
    val attributeResponses: List<AttributeResponse>? = null,
    @SerializedName("available_quantity")
    val availableQuantity: Int? = null,
    @SerializedName("buying_mode")
    val buyingMode: String? = null,
    @SerializedName("catalog_listing")
    val catalogListing: Boolean? = null,
    @SerializedName("catalog_product_id")
    val catalogProductId: String? = null,
    @SerializedName("category_id")
    val categoryId: String? = null,
    @SerializedName("condition")
    val condition: String? = null,
    @SerializedName("currency_id")
    val currencyId: String? = null,
    @SerializedName("differential_pricing")
    val differentialPricing: DifferentialPricingResponse? = null,
    @SerializedName("discounts")
    val discounts: Any? = null,
    @SerializedName("domain_id")
    val domainId: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("installmentsResponse")
    val installmentsResponse: InstallmentsResponse? = null,
    @SerializedName("inventory_id")
    val inventoryId: String? = null,
    @SerializedName("listing_type_id")
    val listingTypeId: String? = null,
    @SerializedName("official_store_id")
    val officialStoreId: Int? = null,
    @SerializedName("official_store_name")
    val officialStoreName: String? = null,
    @SerializedName("order_backend")
    val orderBackend: Int? = null,
    @SerializedName("original_price")
    val originalPrice: Double? = null,
    @SerializedName("permalink")
    val permalink: String? = null,
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("promotions")
    val promotions: List<Any>? = null,
    @SerializedName("sale_price")
    val salePrice: SalePriceResponse? = null,
    @SerializedName("sanitized_title")
    val sanitizedTitle: String? = null,
    @SerializedName("sellerResponse")
    val sellerResponse: SellerResponse? = null,
    @SerializedName("shippingResponse")
    val shippingResponse: ShippingResponse? = null,
    @SerializedName("site_id")
    val siteId: String? = null,
    @SerializedName("stop_time")
    val stopTime: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("thumbnail_id")
    val thumbnailId: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean? = null,
    @SerializedName("winner_item_id")
    val winnerItemId: Any? = null
)