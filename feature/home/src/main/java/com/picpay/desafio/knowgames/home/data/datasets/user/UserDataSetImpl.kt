package com.picpay.desafio.knowgames.home.data.datasets.user

import com.picpay.desafio.knowgames.home.data.datasets.dtos.UserDto
import com.picpay.desafio.knowgames.home.data.services.users.UserService
import javax.inject.Inject

class UserDataSetImpl
@Inject constructor(
    private val userService: UserService
) : UserDataSet {

    override fun fetch(): List<UserDto> {
        val users = userService.getUsers().execute()
        return users.body().orEmpty()
    }
}