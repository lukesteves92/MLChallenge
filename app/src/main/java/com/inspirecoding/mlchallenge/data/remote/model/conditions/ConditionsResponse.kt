package com.inspirecoding.mlchallenge.data.remote.model.conditions

import com.google.gson.annotations.SerializedName

data class ConditionsResponse(
    @SerializedName("context_restrictions")
    val contextRestrictions: List<String>? = null,
    @SerializedName("eligible")
    val eligible: Boolean? = null,
    @SerializedName("end_time")
    val endTime: String? = null,
    @SerializedName("start_time")
    val startTime: String? = null
)