package com.picpay.desafio.android.main.data.services.users

import com.picpay.desafio.android.main.data.datasets.dtos.UserDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface UserService {

    @GET("users")
    fun getUsers(): Single<List<UserDto>>
}