package com.inspirecoding.mlchallenge.di.data

import com.inspirecoding.mlchallenge.BuildConfig
import com.inspirecoding.mlchallenge.data.remote.services.retrofit.RetrofitConfig
import com.inspirecoding.mlchallenge.data.remote.services.service.MLChallengeService
import com.inspirecoding.mlchallenge.data.remote.services.wrapper.RequestWrapper
import com.inspirecoding.mlchallenge.data.remote.services.wrapper.RequestWrapperImpl
import com.inspirecoding.mlchallenge.data.repository.ProductsRepositoryImpl
import com.inspirecoding.mlchallenge.domain.repository.ProductsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val dataModule = module {
    single {
        CoroutineScope(Dispatchers.IO)
    }

    single<RequestWrapper> {
        RequestWrapperImpl()
    }

    single<MLChallengeService> {
        RetrofitConfig.createService(get(), BuildConfig.URL_BASE)
    }

    factory<ProductsRepository> {
        ProductsRepositoryImpl(
            wrapper = get(),
            service = get()
        )
    }
}