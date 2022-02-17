package com.knowgames.main.presentation.di

import dagger.Module

@Module(
    includes = [
        ActivityModule::class,
        FragmentModule::class
    ]
)
abstract class PresentationModule