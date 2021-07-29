package com.picpay.desafio.android.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "users"
)
data class UserEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "image")
    val img: String,
    val name: String,
    @ColumnInfo(name = "user_name")
    val userName: String
)
