package com.picpay.desafio.android.repository.di

import com.picpay.desafio.android.repository.service.retrofit.RetrofitProvider
import org.koin.dsl.module

val repositoryModules = module {
    single { RetrofitProvider.instance }
}