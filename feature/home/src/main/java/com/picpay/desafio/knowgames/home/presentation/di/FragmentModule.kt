package com.picpay.desafio.knowgames.home.presentation.di

import com.picpay.desafio.knowgames.home.presentation.ui.home.fragments.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindUsersFragment(): UsersFragment
}