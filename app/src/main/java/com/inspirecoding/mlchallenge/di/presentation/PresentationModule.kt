package com.inspirecoding.mlchallenge.di.presentation

import com.inspirecoding.mlchallenge.features.home.viewmodel.HomeViewModel
import com.inspirecoding.mlchallenge.features.search.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        HomeViewModel(
            getProductsByCategory = get(),
            getCategories = get()
        )
    }

    viewModel {
        SearchViewModel(
            getProductsBySearch = get()
        )
    }
}