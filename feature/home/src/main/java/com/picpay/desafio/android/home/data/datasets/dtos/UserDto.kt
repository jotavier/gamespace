package com.picpay.desafio.android.home.data.datasets.dtos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("img") val img: String,
    @SerializedName("username") val username: String
) : Parcelable
