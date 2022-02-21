package com.gamespace.main.presentation.ui.main.viewmodel.action

import com.gamespace.core.viewmodel.action.UIAction

internal sealed class MainAction : UIAction {
    object GoToHome(val games: List<GameDataUi>) : MainAction()
}
