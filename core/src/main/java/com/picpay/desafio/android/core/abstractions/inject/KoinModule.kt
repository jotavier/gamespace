package com.picpay.desafio.android.core.abstractions.inject

import org.koin.core.module.Module

interface KoinModule {
    fun init(): Module
}