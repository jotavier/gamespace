package com.picpay.desafio.android.home.domain.di

import com.picpay.desafio.android.home.domain.interactors.users.get.GetLocalUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetLocalUsersInteractorImpl
import com.picpay.desafio.android.home.domain.interactors.users.request.RequestUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.request.RequestUsersInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InteractorModule {

    @Binds
    abstract fun bindGetLocalUsersInteractor(impl: GetLocalUsersInteractorImpl): GetLocalUsersInteractor

    @Binds
    abstract fun bindRequestUsersInteractor(impl: RequestUsersInteractorImpl): RequestUsersInteractor
}