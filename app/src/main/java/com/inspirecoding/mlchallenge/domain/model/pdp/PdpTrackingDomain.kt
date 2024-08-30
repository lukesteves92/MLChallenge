package com.inspirecoding.mlchallenge.domain.model.pdp

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.product.ProductInfoDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PdpTrackingDomain(
    val group: Boolean? = null,
    val productInfo: @RawValue List<ProductInfoDomain>? = null
) : Parcelable
