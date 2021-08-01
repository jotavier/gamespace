package com.picpay.desafio.android.home.domain.di

import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InteractorModule {

    @Binds
    abstract fun bindGetUsersInteractor(impl: GetUsersInteractorImpl): GetUsersInteractor
}