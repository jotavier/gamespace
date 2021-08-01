package com.picpay.desafio.android.base.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.makeToast(message: String, toastLength: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(requireContext(), message, toastLength)
        .show()
}

fun Fragment.finish() = activity?.finish()