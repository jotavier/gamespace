package com.picpay.desafio.android.main.data.repositories.user

import com.picpay.desafio.android.database.daos.UserDao
import com.picpay.desafio.android.main.data.datasets.user.UserDataSet
import com.picpay.desafio.android.main.domain.entities.User
import com.picpay.desafio.android.main.domain.toDomain
import com.picpay.desafio.android.main.domain.toEntity
import io.reactivex.rxjava3.core.Single

class UserRepositoryImpl(
    private val userDataSet: UserDataSet,
    private val userDao: UserDao
) : UserRepository {

    override fun requestUsers(): Single<List<User>> =
        userDataSet.getUsers()
            .doAfterSuccess { usersDto -> userDao.saveUsers(usersDto.toEntity()) }
            .map { usersDto -> usersDto.toDomain() }

    override fun getLocalUsers(): Single<List<User>> =
        userDao.getUsers()
            .map { usersEntities -> usersEntities.toDomain() }
}