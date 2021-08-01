package com.picpay.desafio.android.api.webclient

internal abstract class ApiResource {
    object Connection {
        const val TIMEOUT: Long = 60
    }

    object Read {
        const val TIMEOUT: Long = 60
    }

    object Write {
        const val TIMEOUT: Long = 60
    }
}