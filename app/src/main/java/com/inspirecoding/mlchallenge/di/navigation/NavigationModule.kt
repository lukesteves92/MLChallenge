package com.inspirecoding.mlchallenge.di.navigation

import com.inspirecoding.mlchallenge.navigation.manager.NavigationManager
import org.koin.dsl.module

val navigationModule = module {
    single {
        NavigationManager(get())
    }
}