package com.inspirecoding.mlchallenge.domain.model.path

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PathFromRootDomain(
    val id: String? = null,
    val name: String? = null
) : Parcelable