package com.picpay.desafio.android.main.data.di

import com.picpay.desafio.android.main.data.services.users.UserService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModules = module {
    single { get<Retrofit>().create(UserService::class.java) }
}