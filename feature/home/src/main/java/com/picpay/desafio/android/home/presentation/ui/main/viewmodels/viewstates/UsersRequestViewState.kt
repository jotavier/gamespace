package com.picpay.desafio.android.home.presentation.ui.main.viewmodels.viewstates

import com.picpay.desafio.android.home.presentation.dataui.UserDataUi

sealed class UsersRequestViewState {
    object Loading : UsersRequestViewState()
    object Error : UsersRequestViewState()
    data class Success(val users: List<UserDataUi>) : UsersRequestViewState()
}
