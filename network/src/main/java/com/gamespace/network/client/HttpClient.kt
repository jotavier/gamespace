package com.gamespace.network.client

import kotlin.reflect.KClass

interface HttpClient {
    fun <SERVICE, T : KClass<SERVICE>> create(serviceClass: T): SERVICE
}