package com.picpay.desafio.android.navigation.di

import com.picpay.desafio.android.core.abstractions.navigator.Navigator
import com.picpay.desafio.android.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class NavigationModule {

    @Singleton
    @Binds
    internal abstract fun providesNavigator(impl: NavigatorImpl): Navigator
}