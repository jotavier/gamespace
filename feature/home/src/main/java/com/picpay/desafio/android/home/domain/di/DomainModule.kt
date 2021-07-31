package com.picpay.desafio.android.home.domain.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import org.koin.core.module.Module
import org.koin.dsl.module

internal object DomainModule : KoinModule {
    override fun init(): Module = module {
        plus(InteractorModule.init())
    }
}