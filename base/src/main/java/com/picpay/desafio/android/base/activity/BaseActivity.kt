package com.picpay.desafio.android.base.activity

import com.picpay.desafio.android.base.inject.KoinActivity
import com.picpay.desafio.android.core.abstractions.inject.KoinModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

abstract class BaseActivity(private val module: KoinModule) : KoinActivity() {

    init {
        loadKoinModules(module.init())
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(module.init())
    }
}