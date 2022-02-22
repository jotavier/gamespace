package com.gamespace.main.presentation.ui.splash.viewmodel

import com.gamespace.common.domain.usecase.GetAllGamesUseCase
import com.gamespace.core.viewmodel.ViewModel
import com.gamespace.main.presentation.ui.splash.viewmodel.action.SplashAction
import com.gamespace.main.presentation.ui.splash.viewmodel.state.SplashState

internal class SplashViewModel(private val getGames: GetAllGamesUseCase) :
    ViewModel<SplashState, SplashAction>(SplashState())