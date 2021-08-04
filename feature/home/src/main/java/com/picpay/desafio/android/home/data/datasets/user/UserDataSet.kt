package com.picpay.desafio.android.home.data.datasets.user

import com.picpay.desafio.android.home.data.datasets.dtos.UserDto

interface UserDataSet {
    fun fetch(): List<UserDto>
}