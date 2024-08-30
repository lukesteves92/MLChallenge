package com.inspirecoding.mlchallenge.features.home.state

sealed interface HomeState {
    data class ShowLoading(
        val condition: Boolean
    ) : HomeState
}
