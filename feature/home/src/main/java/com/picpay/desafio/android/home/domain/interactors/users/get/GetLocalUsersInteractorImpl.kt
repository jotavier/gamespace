package com.picpay.desafio.android.home.domain.interactors.users.get

import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetLocalUsersInteractorImpl
@Inject constructor(
    private val userRepository: UserRepository
) : GetLocalUsersInteractor {

    override fun execute(params: Unit): Single<List<User>> = userRepository.getLocalUsers()
}