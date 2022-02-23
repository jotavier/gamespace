package com.gamespace.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gamespace.database.source.Migrations

@Database(
    entities = [],
    version = Migrations.Database.VERSION,
    exportSchema = false
)
internal abstract class GameSpaceDatabase : RoomDatabase() {

    companion object {
        private lateinit var database: GameSpaceDatabase
        fun getInstance(context: Context): GameSpaceDatabase {
            if (::database.isInitialized) return database
            database = Room.databaseBuilder(
                context.applicationContext,
                GameSpaceDatabase::class.java,
                BuildConfig.DATABASE_NAME
            )
                .addMigrations(*Migrations.all)
                .fallbackToDestructiveMigration()
                .build()
            return database
        }
    }
}
