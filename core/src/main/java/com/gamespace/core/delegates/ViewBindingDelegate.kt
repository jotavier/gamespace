package com.gamespace.core.delegates

import android.view.LayoutInflater
import android.view.View
import androidx.annotation.MainThread
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


private const val INFLATE_METHOD = "inflate"
private const val BIND_METHOD = "bind"

inline fun <reified VIEWBINDING : ViewBinding> AppCompatActivity.viewBinding() =
    ActivityViewBindingDelegate(VIEWBINDING::class.java)

inline fun <reified VIEWBINDING : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingDelegate(VIEWBINDING::class.java)

class ActivityViewBindingDelegate<VIEWBINDING : ViewBinding>(
    private val bindingClass: Class<VIEWBINDING>
) : ReadOnlyProperty<AppCompatActivity, VIEWBINDING>, LifecycleObserver {

    private var _binding: VIEWBINDING? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: AppCompatActivity,
        property: KProperty<*>
    ): VIEWBINDING {
        _binding?.let { return it }
        checkIfIsInitializedLifecycleState(thisRef)
        _binding = bindingClass.inflate(thisRef.layoutInflater)
        thisRef.setContentView(binding.root)
        return binding
    }

    private fun checkIfIsInitializedLifecycleState(activity: AppCompatActivity) {
        val lifecycle = activity.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
            error("Cannot access view binding. View lifecycle is ${lifecycle.currentState}!")
    }
}

class FragmentViewBindingDelegate<VIEWBINDING : ViewBinding>(
    private val bindingClass: Class<VIEWBINDING>
) : ReadOnlyProperty<Fragment, VIEWBINDING>, LifecycleObserver {

    private var _binding: VIEWBINDING? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: Fragment,
        property: KProperty<*>
    ): VIEWBINDING {
        _binding?.let { return it }
        checkIfIsInitializedLifecycleState(thisRef)
        _binding = thisRef.view?.let { bindingClass.bind(it) }
        return binding
    }

    private fun checkIfIsInitializedLifecycleState(fragment: Fragment) {
        val lifecycle = fragment.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
            error("Cannot access view binding. View lifecycle is ${lifecycle.currentState}!")
    }
}


@Suppress("UNCHECKED_CAST")
private fun <VIEWBINDING : ViewBinding> Class<VIEWBINDING>.inflate(layoutInflater: LayoutInflater): VIEWBINDING =
    this.getMethod(INFLATE_METHOD, LayoutInflater::class.java)
        .invoke(null, layoutInflater) as VIEWBINDING

@Suppress("UNCHECKED_CAST")
private fun <VIEWBINDING : ViewBinding> Class<VIEWBINDING>.bind(view: View): VIEWBINDING =
    this.getMethod(BIND_METHOD, View::class.java)
        .invoke(null, view) as VIEWBINDING
