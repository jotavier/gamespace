package com.gamespace.home.data.di

import com.gamespace.home.data.repositories.user.UserRepository
import com.gamespace.home.data.repositories.user.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}