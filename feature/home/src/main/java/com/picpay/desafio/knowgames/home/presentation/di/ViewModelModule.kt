package com.picpay.desafio.knowgames.home.presentation.di

import androidx.lifecycle.ViewModel
import com.picpay.desafio.knowgames.core.di.ViewModelKey
import com.picpay.desafio.knowgames.home.presentation.ui.home.viewmodels.UsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel::class)
    abstract fun bindUsersViewModel(viewModel: UsersViewModel): ViewModel
}