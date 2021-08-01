package com.picpay.desafio.android.home.data.di

import com.picpay.desafio.android.home.data.services.users.UserService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
internal abstract class ServiceModule {
    companion object {
        @Singleton
        @Provides
        fun providesUserApiService(apiServiceGenerator: Retrofit): UserService =
            apiServiceGenerator.create(UserService::class.java)
    }
}