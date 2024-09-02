package com.inspirecoding.mlchallenge.features.home.navigation

import com.inspirecoding.mlchallenge.navigation.manager.NavigationManager
import com.inspirecoding.mlchallenge.navigation.screen.Screen

class HomeNavigationImpl(
    private val navManager: NavigationManager
): HomeNavigation {
    override fun navigateToSearch(searchText: String) {
        navManager.navigate(Screen.Search.createRoute(searchText = searchText))    }

    override fun popBackStack() {
        navManager.popBackStack()
    }
}