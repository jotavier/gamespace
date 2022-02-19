package com.gamespace.home.data.repositories.user

import com.gamespace.home.data.Resource
import com.gamespace.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UserRepository {
    fun fetch(): Flowable<Resource<List<User>>>
}