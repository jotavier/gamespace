package com.picpay.desafio.android.api.di

import com.picpay.desafio.android.api.webclient.ApiFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface ApiModule {

    @Singleton
    @Provides
    fun providesApiServiceGenerator(): Retrofit = ApiFactory.apiServiceGenerator
}