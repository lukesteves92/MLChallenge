package com.inspirecoding.mlchallenge.data.remote.model.attribute

import com.inspirecoding.mlchallenge.data.remote.model.value.ValueStructResponse
import com.inspirecoding.mlchallenge.data.remote.model.value.ValueXXResponse

data class AttributeResponse(
    val attribute_group_id: String,
    val attribute_group_name: String,
    val id: String,
    val name: String,
    val source: Long,
    val value_id: String,
    val value_name: String,
    val value_struct: ValueStructResponse,
    val value_type: String,
    val values: List<ValueXXResponse>
)