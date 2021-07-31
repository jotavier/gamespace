package com.picpay.desafio.android.home.data.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.data.datasets.user.UserDataSet
import com.picpay.desafio.android.home.data.datasets.user.UserDataSetImpl
import org.koin.core.module.Module
import org.koin.dsl.module

internal object DataSetModule : KoinModule {
    override fun init(): Module = module {
        single<UserDataSet> { UserDataSetImpl(get()) }
    }
}