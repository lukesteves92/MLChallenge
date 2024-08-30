package com.inspirecoding.mlchallenge.domain.model.value

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValueDomain(
    val id: String? = null,
    val name: String? = null,
    val results: Int? = null
) : Parcelable