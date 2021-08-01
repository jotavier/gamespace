package com.picpay.desafio.android.home.presentation.ui.home.viewmodels.states

import com.picpay.desafio.android.home.presentation.dataui.UserDataUi

sealed class UsersRequestState {
    object Loading : UsersRequestState()
    object Error : UsersRequestState()
    data class Success(val users: List<UserDataUi>) : UsersRequestState()
}
