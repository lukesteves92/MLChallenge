package com.inspirecoding.mlchallenge.data.remote.model.attribute

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueStructResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXXResponse

data class AttributeResponse(
    @SerializedName("attribute_group_id")
    val attributeGroupId: String? = null,
    @SerializedName("attribute_group_name")
    val attributeGroupName: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("source")
    val source: Long? = null,
    @SerializedName("value_id")
    val valueId: String? = null,
    @SerializedName("value_name")
    val valueName: String? = null,
    @SerializedName("value_struct")
    val valueStruct: ValueStructResponse? = null,
    @SerializedName("value_type")
    val valueType: String? = null,
    @SerializedName("values")
    val values: List<ValueXXResponse>? = null
)