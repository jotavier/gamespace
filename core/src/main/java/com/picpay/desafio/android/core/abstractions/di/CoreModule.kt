package com.picpay.desafio.android.core.abstractions.di

import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.core.abstractions.executor.ExecutorImpl
import com.picpay.desafio.android.core.abstractions.navigator.Navigator
import com.picpay.desafio.android.core.abstractions.navigator.NavigatorImpl
import org.koin.dsl.module

val coreModules = module {
    single<Navigator> { NavigatorImpl() }
    single<Executor> { ExecutorImpl() }
}