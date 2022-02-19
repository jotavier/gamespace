package com.gamespace.home.data.di

import dagger.Module

@Module(
    includes = [
        DataSetModule::class,
        RepositoryModule::class,
        ServiceModule::class
    ]
)
internal abstract class DataModule