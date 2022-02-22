package com.gamespace.navigation.di

import com.gamespace.navigation.AppNavigator
import com.gamespace.navigation.AppNavigatorImpl
import org.koin.core.module.Module
import org.koin.dsl.module

class NavigationModule {
    fun get(): Module = module {
        factory<AppNavigator> { AppNavigatorImpl() }
    }
}