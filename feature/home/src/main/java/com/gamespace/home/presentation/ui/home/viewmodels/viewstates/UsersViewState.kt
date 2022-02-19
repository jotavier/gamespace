package com.gamespace.home.presentation.ui.home.viewmodels.viewstates

import com.gamespace.home.presentation.dataui.UserDataUi

sealed class UsersViewState {
    object Loading : UsersViewState()
    object Error : UsersViewState()
    data class Success(val users: List<UserDataUi>) : UsersViewState()
}
