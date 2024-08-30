package com.inspirecoding.mlchallenge.data.remote.model.value

import com.inspirecoding.mlchallenge.data.remote.model.path.PathFromRootResponse

data class ValueXResponse(
    val id: String,
    val name: String,
    val path_from_root: List<PathFromRootResponse>
)