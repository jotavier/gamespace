package com.picpay.desafio.android.main.presentation.di

import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class
    ]
)
abstract class PresentationModule