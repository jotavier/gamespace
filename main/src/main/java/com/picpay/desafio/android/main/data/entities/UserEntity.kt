package com.picpay.desafio.android.main.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserEntity(
    @PrimaryKey
    private var id: Long = 0,
    @ColumnInfo(name = "image")
    val img: String,
    val name: String,
    @ColumnInfo(name = "user_name")
    val userName: String
)
