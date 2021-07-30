package com.picpay.desafio.android.main.data.repositories.user

import com.picpay.desafio.android.main.domain.entities.User
import io.reactivex.rxjava3.core.Single

interface UserRepository {
    fun requestUsers(): Single<List<User>>
    fun getLocalUsers(): Single<List<User>>
}