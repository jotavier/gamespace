package com.picpay.desafio.android.main.presentation.di

import com.picpay.desafio.android.main.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}