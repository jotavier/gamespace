package com.gamespace.network

internal abstract class Connection {
    companion object {
        const val TIMEOUT: Long = 30
    }

    object Read {
        const val TIMEOUT: Long = 30
    }

    object Write {
        const val TIMEOUT: Long = 30
    }
}