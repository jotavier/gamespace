package com.picpay.desafio.android.database.di

import android.content.Context
import com.picpay.desafio.android.core.di.ApplicationContext
import com.picpay.desafio.android.database.PicPayDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        DaoModule::class
    ]
)
abstract class DatabaseModule {
    @Singleton
    @Provides
    fun providesPicPayDatabase(
        @ApplicationContext applicationContext: Context
    ): PicPayDatabase = PicPayDatabase.getInstance(applicationContext)
}