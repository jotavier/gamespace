package com.picpay.desafio.knowgames.home.di

import com.picpay.desafio.knowgames.home.data.di.DataModule
import com.picpay.desafio.knowgames.home.domain.di.DomainModule
import com.picpay.desafio.knowgames.home.presentation.di.PresentationModule
import dagger.Module

@Module(
    includes = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
abstract class HomeModule