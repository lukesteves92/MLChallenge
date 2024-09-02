package com.inspirecoding.mlchallenge.features.search.navigation

import com.inspirecoding.mlchallenge.navigation.manager.NavigationManager

class SearchNavigationImpl(
    private val navManager: NavigationManager
) : SearchNavigation {
    override fun popBackStack() {
        navManager.popBackStack()
    }
}