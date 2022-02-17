package com.picpay.desafio.knowgames.database.di

import android.content.Context
import com.picpay.desafio.knowgames.core.di.ApplicationContext
import com.picpay.desafio.knowgames.database.PicPayDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        DaoModule::class
    ]
)
abstract class DatabaseModule {
    companion object {
        @Singleton
        @Provides
        fun providesPicPayDatabase(
            @ApplicationContext applicationContext: Context
        ): PicPayDatabase = PicPayDatabase.getInstance(applicationContext)
    }
}