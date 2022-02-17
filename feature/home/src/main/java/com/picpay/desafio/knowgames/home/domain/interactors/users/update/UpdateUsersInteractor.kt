package com.picpay.desafio.knowgames.home.domain.interactors.users.update

import com.picpay.desafio.knowgames.core.abstractions.interactor.Interactor
import com.picpay.desafio.knowgames.home.data.Resource
import com.picpay.desafio.knowgames.home.domain.entities.User
import io.reactivex.rxjava3.core.Flowable

interface UpdateUsersInteractor : Interactor<Unit, Flowable<Resource<List<User>>>>