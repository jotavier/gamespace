package com.picpay.desafio.android.main.presentation.dataui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataUi(
    val id: Long,
    val img: String,
    val name: String,
    val userName: String
) : Parcelable
