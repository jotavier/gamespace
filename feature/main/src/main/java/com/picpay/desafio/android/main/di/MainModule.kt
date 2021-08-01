package com.picpay.desafio.android.main.di

import com.picpay.desafio.android.main.presentation.di.PresentationModule
import dagger.Module

@Module(
    includes = [
        PresentationModule::class
    ]
)
abstract class MainModule