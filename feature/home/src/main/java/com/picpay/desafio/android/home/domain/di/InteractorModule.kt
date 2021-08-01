package com.picpay.desafio.android.home.domain.di

import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal interface InteractorModule {

    @Binds
    fun bindGetUsersInteractor(impl: GetUsersInteractorImpl): GetUsersInteractor
}