package com.picpay.desafio.android.home.repositories.user

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.core.extensions.EMPTY
import com.picpay.desafio.android.database.daos.UserDao
import com.picpay.desafio.android.home.data.Resource
import com.picpay.desafio.android.home.data.datasets.user.UserDataSet
import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.data.repositories.user.UserRepositoryImpl
import com.picpay.desafio.android.home.domain.toDomain
import com.picpay.desafio.android.home.factories.UserFactory
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest {

    private val userDataSet: UserDataSet = mock()
    private val userDao: UserDao = mock()
    private lateinit var repository: UserRepository

    @Before
    fun setup() {
        repository = UserRepositoryImpl(userDataSet, userDao)
    }

    @Test
    fun `should return local users if api returns null or empty`() {
        whenever(userDataSet.fetch()).thenReturn(emptyList())
        whenever(userDao.selectAll()).thenReturn(UserFactory.entities)
        repository.fetch().test().apply {
            assertNoErrors()
            assertComplete()
            val content = Resource.Content(UserFactory.entities.toDomain())
            if (content.data.isNullOrEmpty()) {
                error("Lista de usuários nula ou vazia")
            }
            content.data?.forEachIndexed { index, user ->
                val entity = UserFactory.entities[index]
                assertEquals(entity.id, user.id)
                assertEquals(entity.img, user.img)
                assertEquals(entity.name, user.name)
                assertEquals(entity.userName, user.userName)
            }
        }
    }

    @Test
    fun `should return api users if request returns success and is not empty`() {
        whenever(userDataSet.fetch()).thenReturn(UserFactory.dtos)
        whenever(userDao.selectAll()).thenReturn(emptyList())
        repository.fetch().test().apply {
            assertNoErrors()
            assertComplete()
            val content = Resource.Content(UserFactory.dtos.toDomain())
            if (content.data.isNullOrEmpty()) {
                error("Lista de usuários nula ou vazia")
            }
            content.data?.forEachIndexed { index, user ->
                val dto = UserFactory.dtos[index]
                assertEquals(dto.id, user.id)
                assertEquals(dto.img, user.img)
                assertEquals(dto.name, user.name)
                assertEquals(dto.username, user.userName)
            }
        }
    }

    @Test
    fun `should return error if repository fetch returns error`() {
        val error = RuntimeException()
        whenever(userDataSet.fetch()).thenThrow(error)
        whenever(userDao.selectAll()).thenThrow(error)
        repository.fetch().test().apply {
            assertNotComplete()
            assertError(error)
        }
    }
}