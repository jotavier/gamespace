package com.gamespace.home.domain.interactors.users.update

import com.picpay.desafio.gamespace.core.abstractions.interactor.Interactor
import com.gamespace.home.data.Resource
import com.gamespace.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UpdateUsersInteractor : Interactor<Unit, Flowable<Resource<List<User>>>>