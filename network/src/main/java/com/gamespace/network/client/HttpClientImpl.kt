package com.gamespace.network.client

import com.gamespace.network.factory.NetworkProvider
import kotlin.reflect.KClass

internal class HttpClientImpl : HttpClient {
    override fun create(serviceClass: KClass<*>): Any =
        NetworkProvider.apiServiceGenerator.create(serviceClass.java)
}