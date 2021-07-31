package com.picpay.desafio.android.home.data.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.data.services.users.UserService
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

internal object ServiceModule : KoinModule {
    override fun init(): Module = module {
        single { get<Retrofit>().create(UserService::class.java) }
    }
}