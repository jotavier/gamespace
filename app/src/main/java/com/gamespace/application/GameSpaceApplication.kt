package com.gamespace.application

import android.app.Application
import com.gamespace.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GameSpaceApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GameSpaceApplication)
            androidLogger(Level.DEBUG)
            modules(AppModule().get())
        }
    }
}