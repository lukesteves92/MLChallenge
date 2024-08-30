package com.inspirecoding.mlchallenge.domain.model.seller

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SellerDomain(
    val id: Int? = null,
    val nickname: String? = null
) : Parcelable