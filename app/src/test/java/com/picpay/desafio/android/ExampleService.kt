package com.picpay.desafio.android

import com.picpay.desafio.android.home.data.services.users.UserService
import com.picpay.desafio.android.User

class ExampleService(
    private val service: UserService
) {

    fun example(): List<com.picpay.desafio.android.User> {
        val users = service.getUsers().execute()

        return users.body() ?: emptyList()
    }
}