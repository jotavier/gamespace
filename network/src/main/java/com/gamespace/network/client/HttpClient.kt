package com.gamespace.network.client

import kotlin.reflect.KClass

interface HttpClient {
    fun create(serviceClass: KClass<*>): Any
}