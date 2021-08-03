package com.picpay.desafio.android.home.domain.interactors.users.request

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Single

interface RequestUsersInteractor : Interactor<Unit, Single<List<User>>>