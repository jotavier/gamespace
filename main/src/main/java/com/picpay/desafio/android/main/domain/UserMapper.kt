package com.picpay.desafio.android.main.domain

import com.picpay.desafio.android.database.entities.UserEntity
import com.picpay.desafio.android.main.data.datasets.dtos.UserDto
import com.picpay.desafio.android.main.domain.entities.User

fun UserDto.toDomain() = User(
    id = id,
    img = img,
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

fun User.toEntity() = UserEntity(
    id = id,
    img = img,
    name = name,
    userName = userName
)

@JvmName("toEntityUser")
fun List<User>.toEntity(): List<UserEntity> = this.map { user -> user.toEntity() }

fun UserDto.toEntity() = UserEntity(
    id = id,
    img = img,
    name = name,
    userName = username
)

@JvmName("toEntityUserDto")
fun List<UserDto>.toEntity(): List<UserEntity> = this.map { usersDto -> usersDto.toEntity() }