package com.gamespace.core.di

import org.koin.core.module.Module
import org.koin.dsl.module

abstract class FeatureModule {
    open val presentationModule: Module = module { }
    open val dataModule: Module = module { }
    open val domainModule: Module = module { }
    open val additionalModule: Module = module { }

    fun get(): List<Module> =
        listOf(
            presentationModule,
            dataModule,
            domainModule,
            additionalModule
        )
}