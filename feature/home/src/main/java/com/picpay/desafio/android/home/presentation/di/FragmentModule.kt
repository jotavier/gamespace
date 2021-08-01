package com.picpay.desafio.android.home.presentation.di

import com.picpay.desafio.android.home.presentation.ui.home.fragments.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment
}