package com.picpay.desafio.knowgames.core.abstractions.executor

import com.picpay.desafio.knowgames.core.abstractions.interactor.Interactor
import io.reactivex.rxjava3.core.Flowable

interface Executor {
    fun <INPUT, OUTPUT> execute(
        interactor: Interactor<INPUT, Flowable<OUTPUT>>,
        input: INPUT
    ): Flowable<OUTPUT>
}