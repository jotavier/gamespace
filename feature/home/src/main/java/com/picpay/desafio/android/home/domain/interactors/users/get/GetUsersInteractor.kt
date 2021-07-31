package com.picpay.desafio.android.home.domain.interactors.users.get

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Single

interface GetUsersInteractor : Interactor<Unit, Single<List<User>>>