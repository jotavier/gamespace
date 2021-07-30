package com.picpay.desafio.android.di

import com.picpay.desafio.android.core.abstractions.di.coreModules
import com.picpay.desafio.android.database.di.databaseModules
import com.picpay.desafio.android.main.di.mainModules
import com.picpay.desafio.android.repository.di.repositoryModules

internal val applicationModule = listOf(
    coreModules,
    repositoryModules,
    databaseModules,
    mainModules,
)