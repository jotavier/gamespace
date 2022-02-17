package com.picpay.desafio.knowgames.home.data.repositories.user

import com.picpay.desafio.knowgames.home.data.Resource
import com.picpay.desafio.knowgames.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UserRepository {
    fun fetch(): Flowable<Resource<List<User>>>
}