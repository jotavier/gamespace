package com.gamespace.core.delegates

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

private const val BIND_METHOD = "bind"
private const val INFLATE_METHOD = "inflate"

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingPropertyDelegate(T::class.java, this)

class FragmentViewBindingPropertyDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>,
    private val fragment: Fragment
) : ReadOnlyProperty<Fragment, ViewBinding> {

    private val bindingLifecycleObserver = BindingLifecycleObserver()

    private var _binding: T? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: Fragment,
        property: KProperty<*>
    ): ViewBinding {
        _binding?.let { return it }
        checkIfIsInitializedLifecycleState()
        observeFragmentLifecycleStates(thisRef)
        _binding = bindingClass.bind(thisRef.requireView())
        return binding
    }

    private fun checkIfIsInitializedLifecycleState() {
        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
            error("Cannot access view binding. View lifecycle is ${lifecycle.currentState}!")
    }

    private fun observeFragmentLifecycleStates(fragmentRef: Fragment) {
        fragmentRef.viewLifecycleOwner.lifecycle.addObserver(bindingLifecycleObserver)
    }

    private inner class BindingLifecycleObserver : LifecycleObserver {

        private val mainHandler = Handler(Looper.getMainLooper())

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        private fun onDestroy() {
            mainHandler.post { _binding = null }
        }
    }
}

inline fun <reified T : ViewBinding> AppCompatActivity.viewBinding() =
    AppCompatActivityViewBindingPropertyDelegate(T::class.java, this)

class AppCompatActivityViewBindingPropertyDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>,
    private val activity: AppCompatActivity
) : ReadOnlyProperty<AppCompatActivity, ViewBinding>, LifecycleObserver {

    private var _binding: T? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: AppCompatActivity,
        property: KProperty<*>
    ): ViewBinding {
        _binding?.let { return it }
        checkIfIsInitializedLifecycleState()
        _binding = bindingClass.inflate(thisRef.layoutInflater)
        return binding
    }

    private fun checkIfIsInitializedLifecycleState() {
        val lifecycle = activity.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
            error("Cannot access view binding. View lifecycle is ${lifecycle.currentState}!")
    }
}

@Suppress("UNCHECKED_CAST")
private fun <T : ViewBinding> Class<T>.bind(view: View): T =
    this.getMethod(BIND_METHOD, View::class.java)
        .invoke(null, view) as T

@Suppress("UNCHECKED_CAST")
private fun <T : ViewBinding> Class<T>.inflate(layoutInflater: LayoutInflater): T =
    this.getMethod(INFLATE_METHOD, LayoutInflater::class.java)
        .invoke(null, layoutInflater) as T