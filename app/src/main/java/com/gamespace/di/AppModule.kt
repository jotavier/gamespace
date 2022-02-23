package com.gamespace.di

import com.gamespace.database.di.DatabaseModule
import com.gamespace.navigation.di.NavigationModule
import com.gamespace.network.di.NetworkModule
import org.koin.core.module.Module

internal class AppModule {

    fun get(): List<Module> =
        buildList {
            DatabaseModule().get()
            NetworkModule().get()
            NavigationModule().get()
        }
}