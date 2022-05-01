package com.gamespace.main.di.splash

import com.gamespace.core.di.DIModule
import com.gamespace.main.presentation.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal object SplashModule : DIModule {

    override val declarations: List<Module> =
        listOf(presentationModule)

    private val presentationModule
        get() = module {
            viewModel { SplashViewModel(getGames = get()) }
        }
}