package com.inspirecoding.mlchallenge.domain.model.struct

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StructDomain(
    val number: Double? = null,
    val unit: String? = null
) : Parcelable