package com.gamespace.home.data.repositories.user

import com.picpay.desafio.gamespace.database.daos.UserDao
import com.gamespace.home.data.Resource
import com.gamespace.home.data.datasets.user.UserDataSet
import com.gamespace.home.domain.entities.User
import com.gamespace.home.domain.toEntity
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(
    private val userDataSet: UserDataSet,
    private val userDao: UserDao
) : UserRepository {

    override fun fetch(): Flowable<Resource<List<User>>> = Flowable.create({ emmiter ->
        val cachedUsers = userDao.selectAll()
        emmiter.onNext(Resource.Content(cachedUsers?.toDomain()))
        if (cachedUsers.isNullOrEmpty()) {
            emmiter.onNext(Resource.Fetching())
        }

        val newUsers = userDataSet.fetch()
        if (!newUsers.isNullOrEmpty()) {
            emmiter.onNext(Resource.Content(com.gamespace.home.domain.toDomain()))
            userDao.update(newUsers.toEntity())
            emmiter.onComplete()
            return@create
        }
        emmiter.onNext(Resource.Content(cachedUsers?.toDomain()))
        emmiter.onComplete()
    }, BackpressureStrategy.BUFFER)
}