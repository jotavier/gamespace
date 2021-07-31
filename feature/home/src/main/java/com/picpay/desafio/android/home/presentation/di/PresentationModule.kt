package com.picpay.desafio.android.home.presentation.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import org.koin.core.module.Module
import org.koin.dsl.module

internal object PresentationModule : KoinModule {
    override fun init(): Module = module {
        plus(ViewModelModule.init())
    }
}