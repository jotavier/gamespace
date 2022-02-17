package com.picpay.desafio.knowgames.home.factories

import com.picpay.desafio.knowgames.core.extensions.EMPTY
import com.picpay.desafio.knowgames.database.entities.UserEntity
import com.picpay.desafio.knowgames.home.data.datasets.dtos.UserDto
import com.picpay.desafio.knowgames.home.domain.entities.User
import com.picpay.desafio.knowgames.home.presentation.dataui.UserDataUi

object UserFactory {

    val entities: List<UserEntity> = listOf(
        UserEntity(
            id = 1, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        UserEntity(
            id = 2, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        UserEntity(
            id = 3, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        UserEntity(
            id = 4, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        )
    )

    val dtos: List<UserDto> = listOf(
        UserDto(
            id = 1, img = String.EMPTY, name = String.EMPTY, username = String.EMPTY
        ),
        UserDto(
            id = 2, img = String.EMPTY, name = String.EMPTY, username = String.EMPTY
        ),
        UserDto(
            id = 3, img = String.EMPTY, name = String.EMPTY, username = String.EMPTY
        ),
        UserDto(
            id = 4, img = String.EMPTY, name = String.EMPTY, username = String.EMPTY
        )
    )

    val domains: List<User> = listOf(
        User(
            id = 1, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        User(
            id = 2, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        User(
            id = 3, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        ),
        User(
            id = 4, img = String.EMPTY, name = String.EMPTY, userName = String.EMPTY
        )
    )
}