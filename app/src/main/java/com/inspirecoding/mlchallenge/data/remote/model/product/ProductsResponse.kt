package com.inspirecoding.mlchallenge.data.remote.model.product

import com.inspirecoding.mlchallenge.data.remote.model.result.ResultResponse
import com.inspirecoding.mlchallenge.data.remote.model.sort.SortResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablefilter.AvailableFilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablesort.AvailableSortResponse
import com.inspirecoding.mlchallenge.data.remote.model.filter.FilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.paging.PagingResponse
import com.inspirecoding.mlchallenge.data.remote.model.pdp.PdpTrackingResponse

data class ProductsResponse(
    val available_filters: List<AvailableFilterResponse>,
    val available_sorts: List<AvailableSortResponse>,
    val country_default_time_zone: String,
    val filterResponses: List<FilterResponse>,
    val pagingResponse: PagingResponse,
    val pdp_tracking: PdpTrackingResponse,
    val resultResponses: List<ResultResponse>,
    val site_id: String,
    val sortResponse: SortResponse,
    val user_context: Any
)