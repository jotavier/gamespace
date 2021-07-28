package com.picpay.desafio.android.core.abstractions.interactor

interface Interactor<INPUT, OUTPUT> {
    fun execute(params: INPUT): OUTPUT
}