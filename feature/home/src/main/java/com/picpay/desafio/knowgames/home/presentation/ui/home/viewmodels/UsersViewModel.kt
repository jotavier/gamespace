package com.picpay.desafio.knowgames.home.presentation.ui.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.knowgames.base.viewmodel.BaseViewModel
import com.picpay.desafio.knowgames.core.abstractions.executor.Executor
import com.picpay.desafio.knowgames.home.data.Resource
import com.picpay.desafio.knowgames.home.domain.entities.User
import com.picpay.desafio.knowgames.home.domain.interactors.users.update.UpdateUsersInteractor
import com.picpay.desafio.knowgames.home.presentation.mappers.toPresentation
import com.picpay.desafio.knowgames.home.presentation.ui.home.viewmodels.viewstates.UsersViewState
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class UsersViewModel
@Inject constructor(
    private val executor: Executor,
    private val updateUsersInteractor: UpdateUsersInteractor
) : BaseViewModel() {

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