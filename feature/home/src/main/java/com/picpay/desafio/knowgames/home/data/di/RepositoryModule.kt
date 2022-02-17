package com.picpay.desafio.knowgames.home.data.di

import com.picpay.desafio.knowgames.home.data.repositories.user.UserRepository
import com.picpay.desafio.knowgames.home.data.repositories.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}