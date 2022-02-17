package com.knowgames.main.presentation.di

import com.knowgames.main.presentation.ui.main.fragments.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun bindMainFragment(): MainFragment
}