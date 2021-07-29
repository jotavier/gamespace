package com.picpay.desafio.android.base.extensions

import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible

fun View.show() {
    if (!isVisible) {
        isVisible = true
    }
}

fun View.hide() {
    if (isVisible) {
        isVisible = false
    }
}