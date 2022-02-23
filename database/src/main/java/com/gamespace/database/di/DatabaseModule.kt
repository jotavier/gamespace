package com.gamespace.database.di

import com.gamespace.database.GameSpaceDatabase
import org.koin.dsl.module

class DatabaseModule {

    fun get() = module {
        single<GameSpaceDatabase> { GameSpaceDatabase.getInstance(get()) }
    }
}