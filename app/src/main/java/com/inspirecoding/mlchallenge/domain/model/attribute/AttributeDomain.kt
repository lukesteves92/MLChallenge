package com.inspirecoding.mlchallenge.domain.model.attribute

import com.inspirecoding.mlchallenge.domain.model.value.ValueStructDomain
import com.inspirecoding.mlchallenge.domain.model.value.ValueXXDomain

data class AttributeDomain(
    val attribute_group_id: String,
    val attribute_group_name: String,
    val id: String,
    val name: String,
    val source: Long,
    val value_id: String,
    val value_name: String,
    val value_struct: ValueStructDomain,
    val value_type: String,
    val values: List<ValueXXDomain>
)