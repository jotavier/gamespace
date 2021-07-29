package com.picpay.desafio.android.main.presentation.di

import com.picpay.desafio.android.main.presentation.ui.main.di.adapterModules
import com.picpay.desafio.android.main.presentation.ui.main.di.viewModelModules
import org.koin.dsl.module

val presentationModules = module {
    adapterModules
    viewModelModules
}