package com.gamespace.database.source

import androidx.room.migration.Migration

object Migrations {
    object Database {
        const val VERSION: Int = 1
    }

    val all = arrayOf<Migration>()
}