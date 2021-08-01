package com.picpay.desafio.android.di.component

import com.picpay.desafio.android.api.di.ApiModule
import com.picpay.desafio.android.application.PicPayApplication
import com.picpay.desafio.android.core.di.CoreModule
import com.picpay.desafio.android.database.di.DatabaseModule
import com.picpay.desafio.android.di.FeaturesModule
import com.picpay.desafio.android.di.PicPayApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        PicPayApplicationModule::class,
        CoreModule::class,
        DatabaseModule::class,
        ApiModule::class,
        FeaturesModule::class
    ]
)
interface PicPayApplicationComponent : AndroidInjector<PicPayApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<PicPayApplication>
}