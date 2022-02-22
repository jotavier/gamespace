package com.gamespace.main.presentation.di

import com.gamespace.core.di.LayerModule
import com.gamespace.main.presentation.ui.splash.viewmodel.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal class PresentationModule : LayerModule {
    override fun get(): Module = module {
        viewModel {
            SplashViewModel(getGames = get())
        }
    }

}