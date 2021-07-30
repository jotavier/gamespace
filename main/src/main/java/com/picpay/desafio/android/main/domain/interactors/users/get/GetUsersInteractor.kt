package com.picpay.desafio.android.main.domain.interactors.users.get

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import com.picpay.desafio.android.main.domain.entities.User
import io.reactivex.rxjava3.core.Single

interface GetUsersInteractor : Interactor<Unit, Single<List<User>>>