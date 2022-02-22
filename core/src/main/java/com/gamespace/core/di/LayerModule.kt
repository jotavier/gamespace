package com.gamespace.core.di

import org.koin.core.module.Module

fun interface LayerModule {
    fun get(): Module
}