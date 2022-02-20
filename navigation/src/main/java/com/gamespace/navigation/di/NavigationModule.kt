package com.gamespace.navigation.di

import com.gamespace.core.di.LayerModule
import com.gamespace.navigation.AppNavigator
import com.gamespace.navigation.AppNavigatorImpl
import org.koin.core.module.Module
import org.koin.dsl.module

class NavigationModule : LayerModule {
    override val module: Module
        get() = module {
            factory<AppNavigator> { AppNavigatorImpl() }
        }
}