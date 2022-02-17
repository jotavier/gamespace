package com.picpay.desafio.knowgames.database.factories

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.knowgames.database.PicPayDatabase

object TestDatabaseFactory {
    fun getInstance(applicationContext: Context): PicPayDatabase =
        Room.inMemoryDatabaseBuilder(applicationContext, PicPayDatabase::class.java).build()
}