package com.inspirecoding.mlchallenge.features.search.action

sealed interface SearchAction {
    data class GetSearch(val searchText: String, val firstCall: Boolean) : SearchAction
}