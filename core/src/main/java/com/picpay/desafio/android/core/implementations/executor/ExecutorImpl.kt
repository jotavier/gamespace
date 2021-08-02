package com.picpay.desafio.android.core.implementations.executor

import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single

class ExecutorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: @NonNull Scheduler
) : Executor {

    override fun <INPUT, OUTPUT> execute(
        interactor: Interactor<INPUT, Single<OUTPUT>>,
        input: INPUT
    ): Single<OUTPUT> = interactor.execute(input)
        .observeOn(observeOn)
        .subscribeOn(subscribeOn)

    override fun <INPUT> execute(
        interactor: Interactor<INPUT, Completable>,
        input: INPUT
    ): Completable = interactor.execute(input)
        .observeOn(observeOn)
        .subscribeOn(subscribeOn)
}