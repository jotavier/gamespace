package com.picpay.desafio.android.main.presentation.di

import com.picpay.desafio.android.main.presentation.ui.main.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindMainFragment(): MainFragment
}