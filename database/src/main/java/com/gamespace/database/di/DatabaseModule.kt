package com.gamespace.database.di

import com.gamespace.core.di.LayerModule
import com.gamespace.database.GameSpaceDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

internal class DatabaseModule : LayerModule {

    override val module: Module
        get() = module {
            single<GameSpaceDatabase> { GameSpaceDatabase.getInstance(get()) }
        }
}