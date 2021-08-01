package com.picpay.desafio.android.application

import com.picpay.desafio.android.di.component.PicPayApplicationComponent
import dagger.android.AndroidInjector

class PicPayDaggerApplication : PicPayApplication() {
    override fun applicationInjector(): AndroidInjector<out PicPayApplication> {
        return PicPayApplicationComponent.factory().create(this)
    }
}