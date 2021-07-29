package com.picpay.desafio.android.main.data.repositories.user

import com.picpay.desafio.android.database.daos.UserDao
import com.picpay.desafio.android.database.entities.UserEntity
import com.picpay.desafio.android.main.data.datasets.UserDataSet
import com.picpay.desafio.android.main.domain.entities.User
import com.picpay.desafio.android.main.domain.toDomain
import com.picpay.desafio.android.main.domain.toEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(
    private val userDataSet: UserDataSet,
    private val userDao: UserDao
) : UserRepository {

    override fun requestUsers(): Single<List<User>> = userDataSet.getUsers().map { usersDto ->
        userDao.saveUsers(usersDto.toEntity())
    }

    override fun getLocalUsers(): Single<List<UserEntity>> = userDao.getUsers()
}