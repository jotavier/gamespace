package com.gamespace.network.di

import com.gamespace.network.client.HttpClient
import com.gamespace.network.client.HttpClientImpl
import org.koin.dsl.module

class NetworkModule {
    fun get() = module {
        factory<HttpClient> { HttpClientImpl() }
    }
}