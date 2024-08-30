package com.inspirecoding.mlchallenge.domain.model.availablesort

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AvailableSortDomain(
    val id: String? = null,
    val name: String? = null
) : Parcelable