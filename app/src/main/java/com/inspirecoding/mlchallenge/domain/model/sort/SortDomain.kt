package com.inspirecoding.mlchallenge.domain.model.sort

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SortDomain(
    val id: String? = null,
    val name: String? = null
) : Parcelable