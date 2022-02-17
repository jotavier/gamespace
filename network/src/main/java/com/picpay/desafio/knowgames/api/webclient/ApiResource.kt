package com.picpay.desafio.knowgames.api.webclient

internal abstract class ApiResource {
    object Connection {
        const val TIMEOUT: Long = 30
    }

    object Read {
        const val TIMEOUT: Long = 30
    }

    object Write {
        const val TIMEOUT: Long = 30
    }
}