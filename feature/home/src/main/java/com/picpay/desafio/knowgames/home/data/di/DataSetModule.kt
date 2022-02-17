package com.picpay.desafio.knowgames.home.data.di

import com.picpay.desafio.knowgames.home.data.datasets.user.UserDataSet
import com.picpay.desafio.knowgames.home.data.datasets.user.UserDataSetImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataSetModule {

    @Binds
    abstract fun bindUserDataSet(impl: UserDataSetImpl): UserDataSet
}