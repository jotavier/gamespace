package com.gamespace.home.presentation.di

import com.gamespace.core.di.LayerModule
import com.gamespace.home.presentation.ui.feed.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal class PresentationModule : LayerModule {
    override fun get(): Module =
        module {
            viewModel { HomeViewModel() }
        }
}