package com.picpay.desafio.android.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.database.source.Migrations

abstract class PicPayDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME: String = "pic-pay-db"
        private lateinit var database: PicPayDatabase
        fun getInstance(context: Context): PicPayDatabase {
            if (::database.isInitialized) return database
            database = Room.databaseBuilder(
                context.applicationContext,
                PicPayDatabase::class.java,
                DATABASE_NAME
            )
                .addMigrations(*Migrations.all)
                .fallbackToDestructiveMigration()
                .build()
            return database
        }
    }

    abstract fun userDao()
}