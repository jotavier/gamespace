package com.picpay.desafio.android.database.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.database.PicPayDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

object DatabaseModule : KoinModule {
    override fun init(): Module = module {
        single { PicPayDatabase.getInstance(get()) }
        single { get<PicPayDatabase>().userDao() }
    }
}