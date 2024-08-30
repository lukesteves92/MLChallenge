package com.inspirecoding.mlchallenge.domain.model.value

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.struct.StructDomain
import kotlinx.parcelize.Parcelize

@Parcelize
data class ValueXXDomain(
    val id: String? = null,
    val name: String? = null,
    val source: Long? = null,
    val structDomain: StructDomain? = null
) : Parcelable