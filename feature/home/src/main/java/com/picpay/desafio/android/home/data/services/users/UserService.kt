package com.picpay.desafio.android.home.data.services.users

import com.picpay.desafio.android.home.data.datasets.dtos.UserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Single<List<UserDto>>
}