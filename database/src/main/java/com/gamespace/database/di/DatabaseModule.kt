package com.gamespace.database.di

import com.gamespace.database.GameSpaceDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

internal class DatabaseModule {

    override val module: Module
        get() = module {
            single<GameSpaceDatabase> { GameSpaceDatabase.getInstance(get()) }
        }
}