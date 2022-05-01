package com.gamespace.main.presentation.splash.viewmodel.action

import com.gamespace.common.presentation.dataui.GameDataUi
import com.gamespace.core.viewmodel.action.UIAction

internal sealed class SplashAction : UIAction {
    data class GoToHome(val games: List<GameDataUi>) : SplashAction()
}
