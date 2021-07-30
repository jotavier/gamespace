package com.picpay.desafio.android.database.di

import com.picpay.desafio.android.database.PicPayDatabase
import org.koin.dsl.module

val databaseModules = module {
    single { PicPayDatabase.getInstance(get()) }
    single { get<PicPayDatabase>().userDao() }
}