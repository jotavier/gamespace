package com.picpay.desafio.android.home.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Long,
    val img: String,
    val name: String,
    val userName: String
) : Parcelable