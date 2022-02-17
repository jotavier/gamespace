package com.picpay.desafio.knowgames.di

import com.picpay.desafio.knowgames.home.di.HomeModule
import com.knowgames.main.di.MainModule
import dagger.Module

@Module(
    includes = [
        MainModule::class,
        HomeModule::class
    ]
)
abstract class FeaturesModule