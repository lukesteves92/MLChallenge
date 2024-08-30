package com.inspirecoding.mlchallenge.domain.model.value

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValueStructDomain(
    val number: Double? = null,
    val unit: String? = null
) : Parcelable