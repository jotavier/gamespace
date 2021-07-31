package com.picpay.desafio.android.home.presentation.ui.main.viewmodels

import androidx.lifecycle.*
import com.picpay.desafio.android.base.viewmodel.BaseViewModel
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.home.domain.interactors.users.get.GetUsersInteractor
import com.picpay.desafio.android.home.presentation.mappers.toPresentation
import com.picpay.desafio.android.home.presentation.ui.main.viewmodels.viewstates.UsersRequestViewState
import io.reactivex.rxjava3.kotlin.subscribeBy

class MainViewModel(
    private val executor: Executor,
    private val getUsersInteractor: GetUsersInteractor
) : BaseViewModel(), LifecycleObserver {

    private val _usersRequestViewState = MutableLiveData<UsersRequestViewState>()
    val usersRequestViewState: LiveData<UsersRequestViewState> get() = _usersRequestViewState

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getUsers() {
        executor.execute(getUsersInteractor, Unit)
            .doOnSubscribe { _usersRequestViewState.value = UsersRequestViewState.Loading }
            .subscribeBy(
                onSuccess = { users ->
                    _usersRequestViewState.value = UsersRequestViewState.Success(
                        users.toPresentation()
                    )
                },
                onError = { _usersRequestViewState.value = UsersRequestViewState.Error }
            ).disposeOnUnsubscribe()
    }
}