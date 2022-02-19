package com.gamespace.home.interactors.user

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.gamespace.core.extensions.EMPTY
import com.gamespace.home.data.Resource
import com.gamespace.home.data.repositories.user.UserRepository
import com.gamespace.home.domain.entities.User
import com.gamespace.home.domain.interactors.users.update.UpdateUsersInteractor
import com.gamespace.home.domain.interactors.users.update.UpdateUsersInteractorImpl
import io.reactivex.rxjava3.core.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UpdateUsersInteractorTest {

    private lateinit var interactor: UpdateUsersInteractor
    private val repository: UserRepository = mock()

    @Before
    fun setUp() {
        interactor = UpdateUsersInteractorImpl(repository)
    }

    @Test
    fun `should return list of users given that repository returns successful`() {
        val listOfUsers: List<User> = mock()
        val resource = Resource.Content(listOfUsers)
        whenever(repository.fetch()).thenReturn(Flowable.just(resource))
        interactor.execute(Unit).test().apply {
            assertComplete()
            assertNoErrors()
            assertValue(resource)
        }
    }

    @Test
    fun `should return error given that repository returns error`() {
        val error = Exception()
        whenever(repository.fetch()).thenReturn(Flowable.error(error))
        interactor.execute(Unit).test().apply {
            assertComplete()
            assertValue(Resource.Error(String.EMPTY))
        }
    }

    @Test
    fun `should return fetching when repository returns fetching`() {
        val fetchingResource = Resource.Fetching<List<User>>()
        whenever(repository.fetch()).thenReturn(Flowable.just(fetchingResource))
        interactor.execute(Unit).test().apply {
            assertNoErrors()
            assertComplete()
            assertValue(fetchingResource)
        }
    }
}