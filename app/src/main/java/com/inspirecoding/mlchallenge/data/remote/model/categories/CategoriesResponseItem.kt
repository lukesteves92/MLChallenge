package com.inspirecoding.mlchallenge.data.remote.model.categories

import com.google.gson.annotations.SerializedName

data class CategoriesResponseItem(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)