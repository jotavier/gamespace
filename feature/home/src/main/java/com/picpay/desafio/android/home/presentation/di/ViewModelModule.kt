package com.picpay.desafio.android.home.presentation.di

import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import com.picpay.desafio.android.home.presentation.ui.main.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

internal object ViewModelModule : KoinModule {
    override fun init(): Module = module {
        viewModel { MainViewModel(get(), get()) }
    }
}