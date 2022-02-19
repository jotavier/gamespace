package com.gamespace.api.di

import com.gamespace.api.webclient.ApiFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
abstract class ApiModule {

    companion object {
        @Singleton
        @Provides
        fun providesApiServiceGenerator(): Retrofit = ApiFactory.apiServiceGenerator
    }
}