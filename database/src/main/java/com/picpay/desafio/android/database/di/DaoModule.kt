package com.picpay.desafio.android.database.di

import com.picpay.desafio.android.database.PicPayDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {
    @Singleton
    @Provides
    fun providesUserDao(database: PicPayDatabase) = database.userDao()
}