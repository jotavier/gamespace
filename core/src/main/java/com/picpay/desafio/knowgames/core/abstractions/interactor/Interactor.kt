package com.picpay.desafio.knowgames.core.abstractions.interactor

interface Interactor<INPUT, OUTPUT> {
    fun execute(params: INPUT): OUTPUT
}