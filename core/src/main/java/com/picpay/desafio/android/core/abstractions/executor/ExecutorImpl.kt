package com.picpay.desafio.android.core.abstractions.executor

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class ExecutorImpl : Executor {

    override fun <INPUT, OUTPUT> execute(
        interactor: Interactor<INPUT, Single<OUTPUT>>,
        input: INPUT
    ): Single<OUTPUT> = interactor.execute(input)
        .observeOn(Schedulers.io())
        .subscribeOn(Schedulers.io())

    override fun <INPUT> execute(
        interactor: Interactor<INPUT, Completable>,
        input: INPUT
    ): Completable = interactor.execute(input)
        .observeOn(Schedulers.io())
        .subscribeOn(Schedulers.io())
}