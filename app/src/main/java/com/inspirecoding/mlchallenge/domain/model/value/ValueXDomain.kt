package com.inspirecoding.mlchallenge.domain.model.value

import com.inspirecoding.mlchallenge.domain.model.path.PathFromRootDomain

data class ValueXDomain(
    val id: String,
    val name: String,
    val path_from_root: List<PathFromRootDomain>
)