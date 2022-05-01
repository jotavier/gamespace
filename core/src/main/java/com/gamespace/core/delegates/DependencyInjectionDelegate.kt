package com.gamespace.core.delegates

import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.gamespace.core.di.DIModule
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


fun AppCompatActivity.prepareModule(
    diModule: DIModule,
    keepAfterDestroy: Boolean = false
) = ActivityInjectionDelegate(diModule, keepAfterDestroy)

fun Fragment.prepareModule(
    diModule: DIModule,
    keepAfterDestroy: Boolean = false
) = FragmentInjectionDelegate(diModule, keepAfterDestroy)

class ActivityInjectionDelegate(
    private val diModule: DIModule,
    private val keepAfterDestroy: Boolean
) : ReadOnlyProperty<AppCompatActivity, Unit>, LifecycleObserver {

    private val declr by lazy { diModule.declarations }

    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>) = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        loadKoinModules(declr)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        if (keepAfterDestroy) return
        unloadKoinModules(declr)
    }
}

class FragmentInjectionDelegate(
    private val diModule: DIModule,
    private val keepAfterDestroy: Boolean
) : ReadOnlyProperty<Fragment, Unit>, LifecycleObserver {

    private val declr by lazy { diModule.declarations }

    override fun getValue(thisRef: Fragment, property: KProperty<*>) = Unit

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        loadKoinModules(declr)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        if (keepAfterDestroy) return
        Handler(Looper.getMainLooper()).post { unloadKoinModules(declr) }
    }
}