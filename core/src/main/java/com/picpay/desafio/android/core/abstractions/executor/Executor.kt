package com.picpay.desafio.android.core.abstractions.executor

import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface Executor {
    fun <INPUT, OUTPUT> execute(
        interactor: Interactor<INPUT, Single<OUTPUT>>,
        input: INPUT
    ): Single<OUTPUT>

    fun <INPUT> execute(
        interactor: Interactor<INPUT, Completable>,
        input: INPUT
    ): Completable
}