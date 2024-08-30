package com.inspirecoding.mlchallenge.data.remote.model.product

import com.google.gson.annotations.SerializedName
import com.inspirecoding.mlchallenge.data.remote.model.result.ResultResponse
import com.inspirecoding.mlchallenge.data.remote.model.sort.SortResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablefilter.AvailableFilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.availablesort.AvailableSortResponse
import com.inspirecoding.mlchallenge.data.remote.model.filter.FilterResponse
import com.inspirecoding.mlchallenge.data.remote.model.paging.PagingResponse
import com.inspirecoding.mlchallenge.data.remote.model.pdp.PdpTrackingResponse

data class ProductsResponse(
    @SerializedName("available_filters")
    val availableFilters: List<AvailableFilterResponse>? = null,
    @SerializedName("available_sorts")
    val availableSorts: List<AvailableSortResponse>? = null,
    @SerializedName("country_default_time_zone")
    val countryDefaultTimeZone: String? = null,
    @SerializedName("filterResponses")
    val filterResponses: List<FilterResponse>? = null,
    @SerializedName("pagingResponse")
    val pagingResponse: PagingResponse? = null,
    @SerializedName("pdp_tracking")
    val pdpTracking: PdpTrackingResponse? = null,
    @SerializedName("resultResponses")
    val resultResponses: List<ResultResponse>? = null,
    @SerializedName("site_id")
    val siteId: String? = null,
    @SerializedName("sortResponse")
    val sortResponse: SortResponse? = null,
    @SerializedName("user_context")
    val userContext: Any? = null
)