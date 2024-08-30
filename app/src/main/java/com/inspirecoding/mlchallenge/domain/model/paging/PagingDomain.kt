package com.inspirecoding.mlchallenge.domain.model.paging

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PagingDomain(
    val limit: Int? = null,
    val offset: Int? = null,
    val primaryResults: Int? = null,
    val total: Int? = null
) : Parcelable