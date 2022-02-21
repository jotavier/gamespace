package com.gamespace.main.presentation.ui.main.viewmodel.state

import com.gamespace.core.viewmodel.state.UIState

internal sealed class MainState(
    val isLoading: Boolean = true
) : UIState
