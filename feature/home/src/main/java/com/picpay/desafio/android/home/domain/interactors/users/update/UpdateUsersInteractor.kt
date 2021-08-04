package com.picpay.desafio.android.home.domain.interactors.users.update

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import com.picpay.desafio.android.home.data.Resource
import com.picpay.desafio.android.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UpdateUsersInteractor : Interactor<Unit, Flowable<Resource<List<User>>>>