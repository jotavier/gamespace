package com.gamespace.database.factories

import android.content.Context
import androidx.room.Room
import com.gamespace.database.GameSpaceDatabase

object TestDatabaseFactory {
    fun getInstance(applicationContext: Context): GameSpaceDatabase =
        Room.inMemoryDatabaseBuilder(applicationContext, GameSpaceDatabase::class.java).build()
}