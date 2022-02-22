package com.gamespace.common.domain.usecase

import com.gamespace.common.domain.repository.GameRepository


class GetAllGamesUseCase(private val gameRepository: GameRepository) {

    operator fun invoke() = gameRepository.getAll()
}
