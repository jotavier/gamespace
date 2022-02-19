package com.gamespace.home.presentation.ui.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.picpay.desafio.gamespace.base.viewmodel.BaseViewModel
import com.picpay.desafio.gamespace.core.abstractions.executor.Executor
import com.gamespace.home.data.Resource
import com.gamespace.home.domain.entities.User
import com.gamespace.home.domain.interactors.users.update.UpdateUsersInteractor
import com.gamespace.home.presentation.mappers.toPresentation
import com.gamespace.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class UsersViewModel(
    private val updateUsersInteractor: UpdateUsersInteractor
) : ViewModel() {

    private val _usersRequestViewState = MutableLiveData<UsersViewState>()
    val usersViewState: LiveData<UsersViewState> get() = _usersRequestViewState

    fun fetchUsers() {
        executor.execute(updateUsersInteractor, Unit)
            .subscribeBy(
                onNext = ::handleUserResourceState,
                onError = { _usersRequestViewState.value = UsersViewState.Error }
            )
            .disposeOnUnsubscribe()
    }

    private fun handleUserResourceState(resource: Resource<List<User>>) {
        when (resource) {
            is Resource.Content -> _usersRequestViewState.value =
                UsersViewState.Success(resource.data?.toPresentation().orEmpty())
            is Resource.Error -> _usersRequestViewState.value = UsersViewState.Error
            is Resource.Fetching -> _usersRequestViewState.value = UsersViewState.Loading
        }
    }
}