package com.picpay.desafio.android.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.core.di.CoreModule
import com.picpay.desafio.android.database.di.DatabaseModule
import com.picpay.desafio.android.home.di.MainModule
import com.picpay.desafio.android.repository.di.RepositoryModule

object PicPayApplicationModule {
    fun all(): List<KoinModule> = listOf(
        CoreModule,
        DatabaseModule,
        RepositoryModule,
        MainModule
    )
}