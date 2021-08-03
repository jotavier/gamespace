package com.picpay.desafio.android.home.presentation.ui.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.base.viewmodel.BaseViewModel
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetLocalUsersInteractor
import com.picpay.desafio.android.home.domain.interactors.users.request.RequestUsersInteractor
import com.picpay.desafio.android.home.presentation.mappers.toPresentation
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class UsersViewModel
@Inject constructor(
    private val executor: Executor,
    private val requestUsersInteractor: RequestUsersInteractor,
    private val getLocalUsersInteractor: GetLocalUsersInteractor
) : BaseViewModel() {

    private val _usersRequestViewState = MutableLiveData<UsersViewState>()
    val usersViewState: LiveData<UsersViewState> get() = _usersRequestViewState


    fun getUsers() {
        executor.execute(getLocalUsersInteractor, Unit)
            .subscribeBy(
                onSuccess = { users ->
                    _usersRequestViewState.value = UsersViewState.Success(users.toPresentation())
                },
                onError = { requestUsers() }
            )
            .disposeOnUnsubscribe()
    }

    fun requestUsers() {
        executor.execute(requestUsersInteractor, Unit)
            .doOnSubscribe { _usersRequestViewState.value = UsersViewState.Loading }
            .subscribeBy(
                onSuccess = { users ->
                    _usersRequestViewState.value = UsersViewState.Success(users.toPresentation())
                },
                onError = { _usersRequestViewState.value = UsersViewState.Error }
            )
            .disposeOnUnsubscribe()
    }

}