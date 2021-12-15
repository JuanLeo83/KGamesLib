package core.input.mouse.buttonmap.justpressed

import core.input.Action

interface ButtonJustPressed {

    fun getButtonJustPressedActions(): List<Action>

    fun setLeftButtonJustPressed(function: () -> Unit)
    fun setRightButtonJustPressed(function: () -> Unit)
    fun setCenterButtonJustPressed(function: () -> Unit)

}