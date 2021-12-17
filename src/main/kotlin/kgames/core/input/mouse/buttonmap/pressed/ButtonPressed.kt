package kgames.core.input.mouse.buttonmap.pressed

import kgames.core.input.Action

interface ButtonPressed {

    fun getButtonPressedActions(): List<Action>

    fun setLeftButtonPressed(function: () -> Unit)
    fun setRightButtonPressed(function: () -> Unit)
    fun setCenterButtonPressed(function: () -> Unit)

}