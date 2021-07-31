package com.picpay.desafio.android.home.data.datasets.user

import com.picpay.desafio.android.home.data.datasets.dtos.UserDto
import com.picpay.desafio.android.home.data.services.users.UserService
import io.reactivex.rxjava3.core.Single

class UserDataSetImpl(
    private val userService: UserService
) : UserDataSet {

    override fun getUsers(): Single<List<UserDto>> = userService.getUsers()
}