package com.picpay.desafio.knowgames.home.domain.di

import com.picpay.desafio.knowgames.home.domain.interactors.users.update.UpdateUsersInteractor
import com.picpay.desafio.knowgames.home.domain.interactors.users.update.UpdateUsersInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InteractorModule {

    @Binds
    abstract fun bindUpdateUsersInteractor(impl: UpdateUsersInteractorImpl): UpdateUsersInteractor
}