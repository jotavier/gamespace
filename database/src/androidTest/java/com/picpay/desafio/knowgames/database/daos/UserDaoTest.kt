package com.picpay.desafio.knowgames.database.daos

import android.content.Context
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.picpay.desafio.knowgames.core.extensions.EMPTY
import com.picpay.desafio.knowgames.database.PicPayDatabase
import com.picpay.desafio.knowgames.database.entities.UserEntity
import com.picpay.desafio.knowgames.database.factories.TestDatabaseFactory
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class UserDaoTest {

    private lateinit var userDao: UserDao
    private lateinit var database: PicPayDatabase
    private val users by lazy {
        listOf(UserEntity(img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY))
    }

    @Before
    fun setUp() {
        val applicationContext = ApplicationProvider.getApplicationContext<Context>()
        database = TestDatabaseFactory.getInstance(applicationContext)
        userDao = database.userDao()
    }

    @Test
    fun should_GetAllUsers_WithSuccess() {
        userDao.save(users)
        val allUsers = userDao.selectAll()
        assertFalse(allUsers.isNullOrEmpty())
        userDao.clear()
    }

    @Test
    fun should_ClearUsers_WithSuccess() {
        userDao.save(users)
        val allUsers = userDao.selectAll()
        assertFalse(allUsers.isNullOrEmpty())
        userDao.clear()
        val noUsers = userDao.selectAll()
        assertTrue(noUsers.isNullOrEmpty())
    }

    @After
    @Throws(IOException::class)
    fun onCleared() {
        database.close()
    }
}