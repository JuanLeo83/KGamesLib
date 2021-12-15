package core.input.mouse.buttonmap.released

import core.input.Action

interface ButtonReleased {

    fun getButtonReleasedActions(): List<Action>

    fun setLeftButtonReleased(function: () -> Unit)
    fun setRightButtonReleased(function: () -> Unit)
    fun setCenterButtonReleased(function: () -> Unit)
}