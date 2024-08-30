package com.inspirecoding.mlchallenge.domain.model.filter

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.value.ValueXDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class FilterDomain(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val values: @RawValue List<ValueXDomain>? = null
) : Parcelable