package com.picpay.desafio.android.main.di

import com.picpay.desafio.android.main.data.datasets.user.UserDataSet
import com.picpay.desafio.android.main.data.datasets.user.UserDataSetImpl
import com.picpay.desafio.android.main.data.repositories.user.UserRepository
import com.picpay.desafio.android.main.data.repositories.user.UserRepositoryImpl
import com.picpay.desafio.android.main.data.services.users.UserService
import com.picpay.desafio.android.main.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.main.domain.interactors.users.get.GetUsersInteractorImpl
import com.picpay.desafio.android.main.presentation.ui.main.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModules = module {

    // DataSets
    single<UserDataSet> { UserDataSetImpl(get()) }

    // Repositores
    single<UserRepository> { UserRepositoryImpl(get(), get()) }

    // Interactors
    single<GetUsersInteractor> { GetUsersInteractorImpl(get()) }

    // Services
    single { get<Retrofit>().create(UserService::class.java) }

    // ViewModels
    viewModel { MainViewModel(get(), get()) }
}