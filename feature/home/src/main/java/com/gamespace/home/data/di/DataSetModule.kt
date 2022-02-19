package com.gamespace.home.data.di

import com.gamespace.home.data.datasets.user.UserDataSet
import com.gamespace.home.data.datasets.user.UserDataSetImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataSetModule {

    @Binds
    abstract fun bindUserDataSet(impl: UserDataSetImpl): UserDataSet
}