package com.picpay.desafio.android.home.data.di

import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.data.repositories.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}