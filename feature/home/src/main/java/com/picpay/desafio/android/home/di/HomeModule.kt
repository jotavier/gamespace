package com.picpay.desafio.android.home.di

import com.picpay.desafio.android.home.data.di.DataModule
import com.picpay.desafio.android.home.domain.di.DomainModule
import com.picpay.desafio.android.home.presentation.di.PresentationModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
abstract class HomeModule