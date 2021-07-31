package com.picpay.desafio.android.home.data.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.data.repositories.user.UserRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal object RepositoryModule : KoinModule {
    override fun init(): Module = module {
        single<UserRepository> { UserRepositoryImpl(get(), get()) }
    }
}