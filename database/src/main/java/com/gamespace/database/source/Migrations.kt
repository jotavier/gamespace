package com.gamespace.database.source

import androidx.room.migration.Migration

internal object Migrations {
    object Database {
        const val VERSION: Int = 1
    }

    val all = arrayOf<Migration>()
}