package com.picpay.desafio.android.main.data.repositories.user

import com.picpay.desafio.android.main.data.datasets.UserDataSet
import com.picpay.desafio.android.main.domain.entities.User
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(
    private val userDataSet: UserDataSet,
    private val userDao: UserDao
) : UserRepository {

    override fun getUsers(): Single<List<User>> {

    }
}