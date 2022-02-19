package com.gamespace.home.presentation.mappers

import com.gamespace.home.domain.entities.User
import com.gamespace.home.presentation.dataui.UserDataUi

internal fun User.toPresentation() = UserDataUi(
    id = id,
    img = img,
    name = name,
    userName = userName
)

internal fun List<User>.toPresentation() = this.map { user -> user.toPresentation() }