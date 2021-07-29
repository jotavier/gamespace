package com.picpay.desafio.android.main.presentation.ui.main.di

import com.picpay.desafio.android.main.presentation.ui.main.adapters.UserListAdapter
import org.koin.dsl.module

val adapterModules = module {
    single { UserListAdapter() }
}