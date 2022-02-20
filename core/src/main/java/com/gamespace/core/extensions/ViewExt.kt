package com.gamespace.core.extensions

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

fun View.hide() {
    if (isGone || isInvisible) return
    isVisible = false
}

fun View.show() {
    if (isVisible) return
    isVisible = true
}