package com.picpay.desafio.android.main.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val img: String,
    val name: String,
    val userName: String
) : Parcelable