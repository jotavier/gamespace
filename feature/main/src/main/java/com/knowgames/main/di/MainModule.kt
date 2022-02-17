package com.knowgames.main.di

import com.knowgames.main.presentation.di.PresentationModule
import dagger.Module

@Module(
    includes = [
        PresentationModule::class
    ]
)
abstract class MainModule