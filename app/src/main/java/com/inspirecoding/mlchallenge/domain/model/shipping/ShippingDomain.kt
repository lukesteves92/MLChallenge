package com.inspirecoding.mlchallenge.domain.model.shipping

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ShippingDomain(
    val benefits: @RawValue Any? = null,
    val freeShipping: Boolean? = null,
    val logisticType: String? = null,
    val mode: String? = null,
    val promise: @RawValue Any? = null,
    val shippingScore: Int? = null,
    val storePickUp: Boolean? = null,
    val tags: List<String>? = null
) : Parcelable