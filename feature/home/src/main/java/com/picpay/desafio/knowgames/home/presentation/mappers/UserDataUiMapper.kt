package com.picpay.desafio.knowgames.home.presentation.mappers

import com.picpay.desafio.knowgames.home.domain.entities.User
import com.picpay.desafio.knowgames.home.presentation.dataui.UserDataUi

internal fun User.toPresentation() = UserDataUi(
    id = id,
    img = img,
    name = name,
    userName = userName
)

internal fun List<User>.toPresentation() = this.map { user -> user.toPresentation() }