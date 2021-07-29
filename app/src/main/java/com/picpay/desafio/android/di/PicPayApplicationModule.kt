package com.picpay.desafio.android.di

import com.picpay.desafio.android.core.abstractions.di.coreModules
import com.picpay.desafio.android.main.di.mainModules
import org.koin.dsl.module

val applicationModule = module {
    coreModules
    mainModules
}