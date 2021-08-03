package com.picpay.desafio.android.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.database.entities.UserEntity
import io.reactivex.rxjava3.core.Single

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun selectAll(): Single<List<UserEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(users: List<UserEntity>)
}