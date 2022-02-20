package com.gamespace.home.presentation.dataui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDataUi(
    val id: Long,
    val coverUrl: String,
    val name: String,
) : Parcelable
