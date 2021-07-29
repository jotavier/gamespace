package com.picpay.desafio.android.base.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.loadFromUrl(
    imageUrl: String,
    @DrawableRes errorDrawableId: Int,
    onStart: () -> Unit = {},
    onError: () -> Unit = {},
    onSuccess: () -> Unit
) {
    onStart()
    Picasso.get()
        .load(imageUrl)
        .error(errorDrawableId)
        .into(this, object : Callback {
            override fun onSuccess() {
                onSuccess()
            }

            override fun onError(e: Exception?) {
                onError()
            }
        })
}