package com.inspirecoding.mlchallenge.main.application

import android.app.Application
import com.inspirecoding.mlchallenge.di.data.dataModule
import com.inspirecoding.mlchallenge.di.navigation.navigationModule
import com.inspirecoding.mlchallenge.di.presentation.presentationModule
import com.inspirecoding.mlchallenge.di.usecase.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                listOf(
                    navigationModule,
                    presentationModule,
                    dataModule,
                    useCaseModule
                )
            )
        }
    }
}