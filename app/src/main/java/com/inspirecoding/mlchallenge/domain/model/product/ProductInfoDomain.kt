package com.inspirecoding.mlchallenge.domain.model.product

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductInfoDomain(
    val id: String? = null,
    val score: Int? = null,
    val status: String? = null
) : Parcelable