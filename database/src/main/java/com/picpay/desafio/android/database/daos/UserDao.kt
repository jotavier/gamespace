package com.picpay.desafio.android.database.daos

import androidx.room.*
import com.picpay.desafio.android.database.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun selectAll(): List<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(users: List<UserEntity>)

    @Transaction
    fun update(users: List<UserEntity>) {
        clear()
        save(users)
    }

    @Query("DELETE FROM users")
    fun clear()
}