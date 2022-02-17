package com.picpay.desafio.knowgames.home.presentation.di

import com.picpay.desafio.knowgames.home.presentation.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity
}