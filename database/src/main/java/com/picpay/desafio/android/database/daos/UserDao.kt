package com.picpay.desafio.android.database.daos

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("")
    fun getUsers()
}