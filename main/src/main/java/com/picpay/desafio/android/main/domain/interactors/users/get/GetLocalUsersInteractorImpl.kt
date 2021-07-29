package com.picpay.desafio.android.main.domain.interactors.users.get

import com.picpay.desafio.android.main.domain.entities.User
import io.reactivex.rxjava3.core.Single

class GetLocalUsersInteractorImpl : GetLocalUsersInteractor {
    override fun execute(params: Unit): Single<List<User>> {
        TODO("Not yet implemented")
    }
}