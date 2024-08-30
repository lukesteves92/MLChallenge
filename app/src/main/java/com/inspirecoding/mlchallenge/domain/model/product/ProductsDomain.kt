package com.inspirecoding.mlchallenge.domain.model.product

import com.inspirecoding.mlchallenge.domain.model.result.ResultDomain
import com.inspirecoding.mlchallenge.domain.model.sort.SortDomain
import com.inspirecoding.mlchallenge.domain.model.availablefilter.AvailableFilterDomain
import com.inspirecoding.mlchallenge.domain.model.availablesort.AvailableSortDomain
import com.inspirecoding.mlchallenge.domain.model.filter.FilterDomain
import com.inspirecoding.mlchallenge.domain.model.paging.PagingDomain
import com.inspirecoding.mlchallenge.domain.model.pdp.PdpTrackingDomain

data class ProductsDomain(
    val available_filters: List<AvailableFilterDomain>,
    val available_sorts: List<AvailableSortDomain>,
    val country_default_time_zone: String,
    val filterRespons: List<FilterDomain>,
    val pagingDomain: PagingDomain,
    val pdp_tracking: PdpTrackingDomain,
    val resultRespons: List<ResultDomain>,
    val site_id: String,
    val sortResponse: SortDomain,
    val user_context: Any
)