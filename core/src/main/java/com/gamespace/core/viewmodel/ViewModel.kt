package com.gamespace.core.viewmodel

import androidx.lifecycle.ViewModel
import com.gamespace.core.viewmodel.action.UIAction
import com.gamespace.core.viewmodel.state.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class ViewModel<STATE : UIState, ACTION : UIAction>
    (state: STATE) : ViewModel() {

    private var _action: MutableStateFlow<ACTION?> = MutableStateFlow(null)
    val action: StateFlow<ACTION?> get() = _action

    private var _state: MutableStateFlow<STATE> = MutableStateFlow(state)
    val state: StateFlow<STATE> get() = _state

    fun sendAction(actionBlock: () -> ACTION) {
        _action = MutableStateFlow(actionBlock())
    }

    fun setState(stateBlock: (STATE) -> STATE) {
        _state = MutableStateFlow(stateBlock(state.value))
    }
}