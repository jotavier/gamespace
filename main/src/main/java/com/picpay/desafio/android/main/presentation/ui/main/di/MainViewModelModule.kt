package com.picpay.desafio.android.main.presentation.ui.main.di

import com.picpay.desafio.android.main.presentation.ui.main.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { MainViewModel() }
}