package com.picpay.desafio.knowgames.home.data.services.users

import com.picpay.desafio.knowgames.home.data.datasets.dtos.UserDto
import retrofit2.Call
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Call<List<UserDto>>
}