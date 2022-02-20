package com.gamespace.core.delegates

import android.view.LayoutInflater
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


private const val INFLATE_METHOD = "inflate"

inline fun <ACTIVITY : AppCompatActivity, reified VIEWBINDING : ViewBinding> AppCompatActivity.viewBinding() =
    AppCompatActivityViewBindingPropertyDelegate<ACTIVITY, VIEWBINDING>(
        VIEWBINDING::class.java,
        this
    )

class AppCompatActivityViewBindingPropertyDelegate<ACTIVITY : AppCompatActivity, VIEWBINDING : ViewBinding>(
    private val bindingClass: Class<VIEWBINDING>,
    private val activity: AppCompatActivity
) : ReadOnlyProperty<ACTIVITY, VIEWBINDING>, LifecycleObserver {

    private var _binding: VIEWBINDING? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: ACTIVITY,
        property: KProperty<*>
    ): VIEWBINDING {
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
private fun <VIEWBINDING : ViewBinding> Class<VIEWBINDING>.inflate(layoutInflater: LayoutInflater): VIEWBINDING =
    this.getMethod(INFLATE_METHOD, LayoutInflater::class.java)
        .invoke(null, layoutInflater) as VIEWBINDING
