package com.picpay.desafio.android.home.domain.interactors.users.update

import com.picpay.desafio.android.home.data.Resource
import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable
import javax.inject.Inject

class UpdateUsersInteractorImpl
@Inject constructor(
    private val userRepository: UserRepository
) : UpdateUsersInteractor {
    override fun execute(params: Unit): Flowable<Resource<List<User>>> =
        userRepository.fetch()
            .onErrorResumeNext { error ->
                Flowable.just(Resource.Error(error.message.orEmpty()))
            }
}