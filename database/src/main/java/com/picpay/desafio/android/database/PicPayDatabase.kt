package com.picpay.desafio.android.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.picpay.desafio.android.database.daos.UserDao
import com.picpay.desafio.android.database.entities.UserEntity
import com.picpay.desafio.android.database.source.Migrations

@Database(
    entities = [
        UserEntity::class
    ],
    version = Migrations.Database.VERSION,
    exportSchema = false
)
abstract class PicPayDatabase : RoomDatabase() {

    companion object {
        private lateinit var database: PicPayDatabase
        fun getInstance(context: Context): PicPayDatabase {
            if (::database.isInitialized) return database
            database = Room.databaseBuilder(
                context.applicationContext,
                PicPayDatabase::class.java,
                BuildConfig.DATABASE_NAME
            )
                .addMigrations(*Migrations.all)
                .fallbackToDestructiveMigration()
                .build()
            return database
        }
    }

    abstract fun userDao(): UserDao
}