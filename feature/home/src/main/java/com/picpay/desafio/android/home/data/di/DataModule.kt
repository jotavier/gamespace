package com.picpay.desafio.android.home.data.di

import dagger.Module

@Module(
    includes = [
        DataSetModule::class,
        RepositoryModule::class,
        ServiceModule::class
    ]
)
internal interface DataModule