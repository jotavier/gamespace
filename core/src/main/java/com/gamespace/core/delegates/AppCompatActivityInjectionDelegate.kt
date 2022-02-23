package com.gamespace.core.delegates

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.gamespace.core.di.FeatureModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


inline fun <reified FM : FeatureModule> AppCompatActivity.prepareModule() =
    AppCompatActivityInjectionDelegate(FM::class.java)

class AppCompatActivityInjectionDelegate<FM : FeatureModule>(private val featureModuleClass: Class<FM>) :
    ReadOnlyProperty<AppCompatActivity, Unit>, LifecycleObserver {

    private val modules by lazy { featureModuleClass.newInstance().get() }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>) = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        loadKoinModules(modules)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        unloadKoinModules(modules)
    }
}