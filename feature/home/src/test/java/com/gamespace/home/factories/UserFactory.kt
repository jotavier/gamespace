package com.gamespace.home.factories

import com.picpay.desafio.gamespace.core.extensions.EMPTY
import com.picpay.desafio.gamespace.database.entities.UserEntity
import com.gamespace.home.data.datasets.dtos.UserDto
import com.gamespace.home.domain.entities.User

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