package com.gamespace.navigation.di

import com.gamespace.core.di.LayerModule
import com.gamespace.navigation.home.HomeNavigator
import com.gamespace.navigation.home.HomeNavigatorImpl
import org.koin.core.module.Module
import org.koin.dsl.module

class NavigationModule : LayerModule {
    override val module: Module
        get() = module {
            factory<HomeNavigator> { HomeNavigatorImpl() }
        }
}