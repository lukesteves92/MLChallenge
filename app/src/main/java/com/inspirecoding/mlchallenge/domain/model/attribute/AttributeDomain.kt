package com.inspirecoding.mlchallenge.domain.model.attribute

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.value.ValueStructDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueXXDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class AttributeDomain(
    val attributeGroupId: String? = null,
    val attributeGroupName: String? = null,
    val id: String? = null,
    val name: String? = null,
    val source: Long? = null,
    val valueId: String? = null,
    val valueName: String? = null,
    val valueStruct: @RawValue ValueStructDomain? = null,
    val valueType: String? = null,
    val values: @RawValue List<ValueXXDomain>? = null
) : Parcelable