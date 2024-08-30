package com.inspirecoding.mlchallenge.domain.model.value

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.path.PathFromRootDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValueXDomain(
    val id: String? = null,
    val name: String? = null,
    val pathFromRoot: List<PathFromRootDomain>? = null
) : Parcelable