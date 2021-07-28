package com.picpay.desafio.android.application

import android.app.Application
import com.picpay.desafio.android.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@PicPayApplication)
            modules(applicationModule)
        }
    }
}