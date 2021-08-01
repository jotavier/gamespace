package com.picpay.desafio.android.di

import android.content.Context
import com.picpay.desafio.android.application.PicPayApplication
import com.picpay.desafio.android.core.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
abstract class PicPayApplicationModule {

    companion object {

        @Provides
        @ApplicationContext
        fun providesApplicationContext(application: PicPayApplication): Context =
            application.applicationContext
    }
}