package com.gamespace.core.delegates

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

private const val BIND_METHOD = "bind"

inline fun <FRAGMENT : Fragment, reified VIEWBINDING : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingPropertyDelegate<FRAGMENT, VIEWBINDING>(VIEWBINDING::class.java, this)

class FragmentViewBindingPropertyDelegate<FRAGMENT : Fragment, VIEWBINDING : ViewBinding>(
    private val bindingClass: Class<VIEWBINDING>,
    private val fragment: Fragment
) : ReadOnlyProperty<FRAGMENT, VIEWBINDING> {

    private val bindingLifecycleObserver = BindingLifecycleObserver()

    private var _binding: VIEWBINDING? = null
    private val binding get() = _binding!!

    @MainThread
    override fun getValue(
        thisRef: FRAGMENT,
        property: KProperty<*>
    ): VIEWBINDING {
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

@Suppress("UNCHECKED_CAST")
private fun <VIEWBINDING : ViewBinding> Class<VIEWBINDING>.bind(view: View): VIEWBINDING =
    this.getMethod(BIND_METHOD, View::class.java)
        .invoke(null, view) as VIEWBINDING
