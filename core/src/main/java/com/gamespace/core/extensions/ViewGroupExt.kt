package com.gamespace.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(
    @LayoutRes layoutId: Int,
    attachToRoot: Boolean = false,
    viewBlock: View.() -> Unit = {}
): View? = LayoutInflater.from(this.context)
    .inflate(layoutId, this, attachToRoot)
    .apply(viewBlock)