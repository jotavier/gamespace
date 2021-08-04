package com.picpay.desafio.android.home.data.repositories.user

import com.picpay.desafio.android.home.data.Resource
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UserRepository {
    fun fetch(): Flowable<Resource<List<User>>>
}