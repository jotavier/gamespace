package com.picpay.desafio.android.home.presentation.ui.home.viewmodels

import androidx.lifecycle.*
import com.picpay.desafio.android.base.viewmodel.BaseViewModel
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.presentation.mappers.toPresentation
import com.picpay.desafio.android.home.presentation.ui.home.viewmodels.states.UsersRequestState
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class UsersViewModel
@Inject constructor(
    private val executor: Executor,
    private val getUsersInteractor: GetUsersInteractor
) : BaseViewModel(), LifecycleObserver {

    private val _usersRequestViewState = MutableLiveData<UsersRequestState>()
    val usersRequestState: LiveData<UsersRequestState> get() = _usersRequestViewState

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getUsers() {
        executor.execute(getUsersInteractor, Unit)
            .doOnSubscribe { _usersRequestViewState.value = UsersRequestState.Loading }
            .subscribeBy(
                onSuccess = { users ->
                    _usersRequestViewState.value = UsersRequestState.Success(users.toPresentation())
                },
                onError = { _usersRequestViewState.value = UsersRequestState.Error }
            )
            .disposeOnUnsubscribe()
    }
}