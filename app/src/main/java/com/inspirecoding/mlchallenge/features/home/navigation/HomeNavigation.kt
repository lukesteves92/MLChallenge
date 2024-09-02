package com.inspirecoding.mlchallenge.features.home.navigation

interface HomeNavigation {
    fun navigateToSearch(searchText: String)
    fun popBackStack()
}