package com.inspirecoding.mlchallenge.domain.model.installments

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InstallmentsDomain(
    val amount: Double? = null,
    val currencyId: String? = null,
    val quantity: Int? = null,
    val rate: Double? = null
) : Parcelable