package com.picpay.desafio.android.core.di

import androidx.lifecycle.ViewModelProvider
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.core.implementations.executor.ExecutorImpl
import com.picpay.desafio.android.core.di.factories.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Singleton


@Module
abstract class CoreModule {

    companion object {
        @Singleton
        @Provides
        fun providesExecutor(): Executor =
            ExecutorImpl(
                observeOn = AndroidSchedulers.mainThread(),
                subscribeOn = Schedulers.io()
            )
    }

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}