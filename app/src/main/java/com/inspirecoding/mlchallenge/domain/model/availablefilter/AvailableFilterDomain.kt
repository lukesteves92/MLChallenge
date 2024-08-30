package com.inspirecoding.mlchallenge.domain.model.availablefilter

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.value.ValueDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AvailableFilterDomain(
    val id: String? = null,
    val name: String? = null,
    val type: String? = null,
    val valueResponses: @RawValue List<ValueDomain>? = null
) : Parcelable