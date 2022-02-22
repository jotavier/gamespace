package com.gamespace.common.domain.repository

import com.gamespace.common.domain.model.Game

interface GameRepository {
    fun getAll() : List<Game>
}
