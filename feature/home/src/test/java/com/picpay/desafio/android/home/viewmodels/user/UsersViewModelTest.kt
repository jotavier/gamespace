package com.picpay.desafio.android.home.viewmodels.user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.core.extensions.EMPTY
import com.picpay.desafio.android.home.data.Resource
import com.picpay.desafio.android.home.domain.interactors.users.update.UpdateUsersInteractor
import com.picpay.desafio.android.home.factories.UserFactory
import com.picpay.desafio.android.home.presentation.mappers.toPresentation
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.UsersViewModel
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import io.reactivex.rxjava3.core.Flowable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UsersViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: UsersViewModel
    private val executor: Executor = mock()
    private val updateUsersInteractor: UpdateUsersInteractor = mock()
    private val usersViewStateObserver: Observer<UsersViewState> = mock()

    @Before
    fun setup() {
        viewModel = UsersViewModel(executor, updateUsersInteractor)
        viewModel.usersViewState.observeForever(usersViewStateObserver)
    }

    @Test
    fun `should set success state when interactor returns content`() {
        whenever(updateUsersInteractor.execute(Unit)).thenReturn(
            Flowable.just(
                Resource.Content(UserFactory.domains)
            )
        )
        usersViewStateObserver.onChanged(UsersViewState.Success(UserFactory.domains.toPresentation()))
    }

    @Test
    fun `should set loading state when interactor returns fetching`() {
        whenever(updateUsersInteractor.execute(Unit)).thenReturn(
            Flowable.just(Resource.Fetching())
        )
        usersViewStateObserver.onChanged(UsersViewState.Loading)
    }

    @Test
    fun `should set error state when interactor returns error`() {
        whenever(updateUsersInteractor.execute(Unit)).thenReturn(
            Flowable.just(Resource.Error(String.EMPTY))
        )
        usersViewStateObserver.onChanged(UsersViewState.Error)
    }

    @Test
    fun `should set error state when interactor gets error`() {
        whenever(updateUsersInteractor.execute(Unit)).thenReturn(
            Flowable.error(Exception())
        )
        usersViewStateObserver.onChanged(UsersViewState.Error)
    }

}