package com.picpay.desafio.knowgames.di.component

import com.picpay.desafio.knowgames.api.di.ApiModule
import com.picpay.desafio.knowgames.application.PicPayApplication
import com.picpay.desafio.knowgames.core.di.CoreModule
import com.picpay.desafio.knowgames.database.di.DatabaseModule
import com.picpay.desafio.knowgames.di.FeaturesModule
import com.picpay.desafio.knowgames.di.PicPayApplicationModule
import com.picpay.desafio.knowgames.navigation.di.NavigationModule
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
        NavigationModule::class,
        FeaturesModule::class
    ]
)
interface PicPayApplicationComponent : AndroidInjector<PicPayApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<PicPayApplication>
}