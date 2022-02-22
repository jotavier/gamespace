package com.gamespace.core.di

import org.koin.core.module.Module
import org.koin.dsl.module

abstract class FeatureModule {
    open val presentationModule: LayerModule = LayerModule { module {} }
    open val dataModule: LayerModule = LayerModule { module {} }
    open val domainModule: LayerModule = LayerModule { module {} }
    open val additionalModule: LayerModule = LayerModule { module {} }

    fun get(): List<Module> =
        listOf(
            presentationModule.get(),
            dataModule.get(),
            domainModule.get(),
            additionalModule.get()
        )
}
