package com.inspirecoding.mlchallenge.di.navigation

import com.inspirecoding.mlchallenge.features.home.navigation.HomeNavigation
import com.inspirecoding.mlchallenge.features.home.navigation.HomeNavigationImpl
import com.inspirecoding.mlchallenge.features.search.navigation.SearchNavigation
import com.inspirecoding.mlchallenge.features.search.navigation.SearchNavigationImpl
import com.inspirecoding.mlchallenge.navigation.manager.NavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(get())
    }

    factory<HomeNavigation> {
        HomeNavigationImpl(navManager = get())
    }

    factory<SearchNavigation> {
        SearchNavigationImpl(navManager = get())
    }
}