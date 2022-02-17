package com.picpay.desafio.knowgames.home.domain.di

import dagger.Module

@Module(
    includes = [
        InteractorModule::class
    ]
)
internal abstract class DomainModule