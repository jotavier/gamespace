package com.picpay.desafio.android.main.di

import com.picpay.desafio.android.main.data.di.dataModules
import com.picpay.desafio.android.main.domain.di.domainModules
import com.picpay.desafio.android.main.presentation.di.presentationModules
import org.koin.dsl.module

val mainModules = module {
    dataModules
    presentationModules
    domainModules
}