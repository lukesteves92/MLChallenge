package com.inspirecoding.mlchallenge.di.usecase

import com.inspirecoding.mlchallenge.domain.usecase.categories.GetCategories
import com.inspirecoding.mlchallenge.domain.usecase.products.GetProductsByCategory
import com.inspirecoding.mlchallenge.domain.usecase.search.GetProductsBySearch
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetProductsByCategory(repository = get()) }
    factory { GetProductsBySearch(repository = get()) }
    factory { GetCategories(repository = get()) }
}