package com.gamespace.home.data.datasets.user

import com.gamespace.home.data.datasets.dtos.UserDto

interface UserDataSet {
    fun fetch(): List<UserDto>
}