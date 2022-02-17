package com.picpay.desafio.knowgames.di

import android.content.Context
import com.picpay.desafio.knowgames.application.PicPayApplication
import com.picpay.desafio.knowgames.core.di.ApplicationContext
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