package com.gamespace.network.client

import com.gamespace.network.factory.NetworkProvider
import kotlin.reflect.KClass

internal class HttpClientImpl : HttpClient {

    override fun <SERVICE, T : KClass<SERVICE>> create(serviceClass: T): SERVICE =
        NetworkProvider.apiServiceGenerator.create(serviceClass.java)
}