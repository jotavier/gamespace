package com.picpay.desafio.android.main.domain.interactors.users.request

import com.picpay.desafio.android.main.data.repositories.user.UserRepository
import com.picpay.desafio.android.main.domain.entities.User
import io.reactivex.rxjava3.core.Single

class RequestUsersInteractorImpl(
    private val userRepository: UserRepository
) : RequestUsersInteractor {
    override fun execute(params: Unit): Single<List<User>> = userRepository.requestUsers()
}