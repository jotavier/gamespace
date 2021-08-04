package com.picpay.desafio.android.core.implementations.executor

import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.core.abstractions.interactor.Interactor
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler

class ExecutorImpl(
    private val observeOn: Scheduler,
    private val subscribeOn: @NonNull Scheduler
) : Executor {
    override fun <INPUT, OUTPUT> execute(
        interactor: Interactor<INPUT, Flowable<OUTPUT>>,
        input: INPUT
    ): Flowable<OUTPUT> = interactor.execute(input)
        .observeOn(observeOn)
        .subscribeOn(subscribeOn)

}