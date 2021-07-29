package com.picpay.desafio.android.main.presentation.ui.main.viewmodels

import androidx.lifecycle.*
import com.picpay.desafio.android.base.viewmodel.BaseViewModel
import com.picpay.desafio.android.core.abstractions.executor.Executor
import com.picpay.desafio.android.main.domain.interactors.users.get.GetLocalUsersInteractor
import com.picpay.desafio.android.main.domain.interactors.users.request.RequestUsersInteractor
import com.picpay.desafio.android.main.presentation.ui.main.viewmodels.viewstates.UsersRequestViewState
import io.reactivex.rxjava3.kotlin.subscribeBy

class MainViewModel(
    private val executor: Executor,
    private val requestUsersInteractor: RequestUsersInteractor,
    private val getLocalUsersInteractor: GetLocalUsersInteractor
) : BaseViewModel(), LifecycleObserver {

    private val _usersRequestViewState = MutableLiveData<UsersRequestViewState>()
    val usersRequestViewState: LiveData<UsersRequestViewState> get() = _usersRequestViewState

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun requestUsers() {
        executor.execute(requestUsersInteractor, Unit)
            .doOnSubscribe { _usersRequestViewState.value = UsersRequestViewState.Loading }
            .subscribeBy(
                onComplete = { users ->

                },
                onError = {

                }
            )
    }
}