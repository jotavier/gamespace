package com.picpay.desafio.knowgames.home.presentation.ui.home.viewmodels.viewstates

import com.picpay.desafio.knowgames.home.presentation.dataui.UserDataUi

sealed class UsersViewState {
    object Loading : UsersViewState()
    object Error : UsersViewState()
    data class Success(val users: List<UserDataUi>) : UsersViewState()
}
