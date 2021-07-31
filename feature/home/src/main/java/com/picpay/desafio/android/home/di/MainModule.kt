package com.picpay.desafio.android.home.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.data.di.DataModule
import com.picpay.desafio.android.home.domain.di.DomainModule
import com.picpay.desafio.android.home.presentation.di.PresentationModule
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule : KoinModule {
    override fun init(): Module = module {
        plus(DataModule.init())
        plus(DomainModule.init())
        plus(PresentationModule.init())
    }
}