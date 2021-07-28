package com.picpay.desafio.android.main.data.datasets.dtos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto(
    @SerializedName("img") val img: String,
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("username") val username: String
) : Parcelable
