package com.picpay.desafio.android.main.presentation.mappers

import com.picpay.desafio.android.main.domain.entities.User
import com.picpay.desafio.android.main.presentation.dataui.UserDataUi

internal fun User.toPresentation() = UserDataUi(
    id = id,
    img = img,
    name = name,
    userName = userName
)

internal fun List<User>.toPresentation() = this.map { user -> user.toPresentation() }