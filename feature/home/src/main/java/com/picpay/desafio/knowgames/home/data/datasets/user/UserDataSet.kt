package com.picpay.desafio.knowgames.home.data.datasets.user

import com.picpay.desafio.knowgames.home.data.datasets.dtos.UserDto

interface UserDataSet {
    fun fetch(): List<UserDto>
}