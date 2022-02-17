package com.picpay.desafio.knowgames.application

import com.picpay.desafio.knowgames.di.component.DaggerPicPayApplicationComponent
import dagger.android.AndroidInjector

class PicPayDaggerApplication : PicPayApplication() {
    override fun applicationInjector(): AndroidInjector<out PicPayApplication> {
        return DaggerPicPayApplicationComponent.factory().create(this)
    }
}