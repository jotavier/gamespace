package com.picpay.desafio.android.di

import com.picpay.desafio.android.home.di.HomeModule
import com.picpay.desafio.android.main.di.MainModule
import dagger.Module

@Module(
    includes = [
        MainModule::class,
        HomeModule::class
    ]
)
abstract class FeaturesModule