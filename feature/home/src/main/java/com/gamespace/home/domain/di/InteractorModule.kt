package com.gamespace.home.domain.di

import com.gamespace.home.domain.interactors.users.update.UpdateUsersInteractor
import com.gamespace.home.domain.interactors.users.update.UpdateUsersInteractorImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class InteractorModule {

    @Binds
    abstract fun bindUpdateUsersInteractor(impl: UpdateUsersInteractorImpl): UpdateUsersInteractor
}