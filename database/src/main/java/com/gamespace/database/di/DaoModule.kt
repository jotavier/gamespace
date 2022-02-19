package com.gamespace.database.di


import com.gamespace.core.di.LayerModule
import com.gamespace.database.GameSpaceDatabase
import com.gamespace.database.daos.UserDao
import org.koin.core.module.Module
import org.koin.dsl.module

internal class DaoModule : LayerModule {

    override val module: Module
        get() = module {
            single<UserDao> { get<GameSpaceDatabase>().userDao() }
        }
}