package com.inspirecoding.mlchallenge.domain.model.product

import android.os.Parcelable
import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.domain.model.sort.SortDomain
import com.inspirecoding.mlchallenge.domain.model.availablefilter.AvailableFilterDomain
import com.inspirecoding.mlchallenge.domain.model.availablesort.AvailableSortDomain
import com.inspirecoding.mlchallenge.domain.model.filter.FilterDomain
import com.inspirecoding.mlchallenge.domain.model.paging.PagingDomain
import com.inspirecoding.mlchallenge.domain.model.pdp.PdpTrackingDomain
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ProductsDomain(
    val availableFilters: List<AvailableFilterDomain>? = null,
    val availableSorts: List<AvailableSortDomain>? = null,
    val countryDefaultTimeZone: String? = null,
    val filterResponses: List<FilterDomain>? = null,
    val pagingDomain: PagingDomain? = null,
    val pdpTracking: PdpTrackingDomain? = null,
    val resultResponses: @RawValue List<ResultDomain>? = null,
    val siteId: String? = null,
    val sortResponse: @RawValue SortDomain? = null,
    val userContext: @RawValue Any? = null
) : Parcelable