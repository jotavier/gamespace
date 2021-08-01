package com.picpay.desafio.android.home.presentation.di

import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class
    ]
)
internal abstract class PresentationModule