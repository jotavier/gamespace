package com.picpay.desafio.android.repository.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.repository.network.ApiFactory
import org.koin.core.module.Module
import org.koin.dsl.module

object RepositoryModule : KoinModule {
    override fun init(): Module = module {
        single { ApiFactory.get() }
    }
}