package com.inspirecoding.mlchallenge.domain.model.conditions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConditionsDomain(
    val contextRestrictions: List<String>? = null,
    val eligible: Boolean? = null,
    val endTime: String? = null,
    val startTime: String? = null
) : Parcelable