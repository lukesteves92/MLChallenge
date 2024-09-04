package com.inspirecoding.mlchallenge.domain.model.result

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.saleprice.SalePriceDomain
import com.inspirecoding.mlchallenge.domain.model.seller.SellerDomain
import com.inspirecoding.mlchallenge.domain.model.shipping.ShippingDomain
import com.inspirecoding.mlchallenge.domain.model.attribute.AttributeDomain
import com.inspirecoding.mlchallenge.domain.model.differentialpricing.DifferentialPricingDomain
import com.inspirecoding.mlchallenge.domain.model.installments.InstallmentsDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ResultDomain(
    val acceptsMercadoPago: Boolean? = null,
    val attributeResponses: List<AttributeDomain>? = null,
    val availableQuantity: Int? = null,
    val buyingMode: String? = null,
    val catalogListing: Boolean? = null,
    val catalogProductId: String? = null,
    val categoryId: String? = null,
    val condition: String? = null,
    val currencyId: String? = null,
    val differentialPricing: DifferentialPricingDomain? = null,
    val discounts: @RawValue Any? = null,
    val domainId: String? = null,
    val id: String? = null,
    val installmentsDomain: InstallmentsDomain? = null,
    val inventoryId: String? = null,
    val listingTypeId: String? = null,
    val officialStoreId: Int? = null,
    val officialStoreName: String? = null,
    val orderBackend: Int? = null,
    val originalPrice: Double? = null,
    val permalink: String? = null,
    val price: String? = null,
    val promotions: @RawValue List<Any>? = null,
    val salePrice: @RawValue SalePriceDomain? = null,
    val sanitizedTitle: String? = null,
    val sellerDomain: @RawValue SellerDomain? = null,
    val shippingDomain: @RawValue ShippingDomain? = null,
    val siteId: String? = null,
    val stopTime: String? = null,
    val thumbnail: String? = null,
    val thumbnailId: String? = null,
    val title: String? = null,
    val useThumbnailId: Boolean? = null,
    val winnerItemId: @RawValue Any? = null
) : Parcelable