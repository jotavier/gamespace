package com.gamespace.core.di

import org.koin.core.module.Module

interface DIModule {
    val declarations: List<Module>
}