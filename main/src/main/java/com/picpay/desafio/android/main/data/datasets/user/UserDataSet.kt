package com.picpay.desafio.android.main.data.datasets.user

import com.picpay.desafio.android.main.data.datasets.dtos.UserDto
import io.reactivex.rxjava3.core.Single

interface UserDataSet {
    fun getUsers() : Single<List<UserDto>>
}