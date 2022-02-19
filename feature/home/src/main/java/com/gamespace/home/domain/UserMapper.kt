package com.gamespace.home.domain

import com.picpay.desafio.gamespace.core.extensions.EMPTY
import com.picpay.desafio.gamespace.database.entities.UserEntity
import com.gamespace.home.data.datasets.dtos.UserDto
import com.gamespace.home.domain.entities.User

fun UserDto.toDomain() = User(
    id = id,
    img = img ?: String.EMPTY,
    name = name,
    userName = username
)

@JvmName("toDomainUserDto")
fun List<UserDto>.toDomain(): List<User> = this.map { userDto -> userDto.toDomain() }

fun UserEntity.toDomain() = User(
    id = id,
    img = img,
    name = name,
    userName = userName
)

@JvmName("toDomainUserEntity")
fun List<UserEntity>.toDomain(): List<User> = this.map { userEntity -> userEntity.toDomain() }

fun UserDto.toEntity() = UserEntity(
    id = id,
    img = img ?: String.EMPTY,
    name = name,
    userName = username
)

fun List<UserDto>.toEntity(): List<UserEntity> = this.map { usersDto -> usersDto.toEntity() }