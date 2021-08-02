package com.picpay.desafio.android.home.interactors.user

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.home.data.repositories.user.UserRepository
import com.picpay.desafio.android.home.domain.entities.User
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractorImpl
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsersInteractorTest {

    private lateinit var interactor: GetUsersInteractor
    private val repository: UserRepository = mock()
    private val listOfUsers: List<User> = mock()

    @Before
    fun setUp() {
        interactor = GetUsersInteractorImpl(repository)
    }

    @Test
    fun `should return list of users given that request was successful`() {
        whenever(repository.requestUsers()).thenReturn(Single.just(listOfUsers))
        interactor.execute(Unit).test().apply {
            assertComplete()
            assertNoErrors()
            assertValue(listOfUsers)
        }
    }

    @Test
    fun `should return cached list of users given that request returns error`() {
        val error = Exception()
        repository.run {
            whenever(requestUsers()).thenReturn(Single.error(error))
            whenever(getLocalUsers()).thenReturn(Single.just(listOfUsers))
        }
        interactor.execute(Unit).test().apply {
            assertValue(listOfUsers)
            assertComplete()
        }
    }

    @Test
    fun `should return error given that request and database query returns error`() {
        val error = Exception()
        repository.run {
            whenever(requestUsers()).thenReturn(Single.error(error))
            whenever(getLocalUsers()).thenReturn(Single.error(error))
        }
        interactor.execute(Unit).test().apply {
            assertError(error)
            assertNoValues()
            assertNotComplete()
        }
    }
}