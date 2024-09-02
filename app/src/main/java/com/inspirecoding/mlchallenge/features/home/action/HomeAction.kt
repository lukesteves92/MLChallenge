package com.inspirecoding.mlchallenge.features.home.action

sealed interface HomeAction {
    data class GetCategories(val category: String) : HomeAction
}