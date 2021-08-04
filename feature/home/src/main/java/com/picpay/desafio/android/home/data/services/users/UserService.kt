package com.picpay.desafio.android.home.data.services.users

import com.picpay.desafio.android.home.data.datasets.dtos.UserDto
import retrofit2.Response
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Response<List<UserDto>>
}