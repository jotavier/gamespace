package com.picpay.desafio.android.home.domain.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractorImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal object InteractorModule : KoinModule {
    override fun init(): Module = module {
        single<GetUsersInteractor> { GetUsersInteractorImpl(get()) }
    }
}