package com.inspirecoding.mlchallenge.features.search.state


sealed interface SearchState {
    data class ShowLoading(
        val condition: Boolean
    ) : SearchState
}