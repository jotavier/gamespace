package com.gamespace.network.client

import com.gamespace.network.factory.NetworkFactory
import kotlin.reflect.KClass

internal class HttpClientImpl : HttpClient {
    override fun create(serviceClass: KClass<*>): Any =
        NetworkFactory.apiServiceGenerator.create(serviceClass.java)
}