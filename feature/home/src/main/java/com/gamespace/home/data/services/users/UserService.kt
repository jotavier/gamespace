package com.gamespace.home.data.services.users

import com.gamespace.home.data.datasets.dtos.UserDto
import retrofit2.Call
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Call<List<UserDto>>
}