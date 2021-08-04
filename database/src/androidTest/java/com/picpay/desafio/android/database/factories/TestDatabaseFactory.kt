package com.picpay.desafio.android.database.factories

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.android.database.PicPayDatabase

object TestDatabaseFactory {
    fun getInstance(applicationContext: Context): PicPayDatabase =
        Room.inMemoryDatabaseBuilder(applicationContext, PicPayDatabase::class.java).build()
}