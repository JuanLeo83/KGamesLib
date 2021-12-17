package kgames.core.input.mouse.buttonmap.justpressed

import kgames.core.input.Action

interface ButtonJustPressed {

    fun getButtonJustPressedActions(): List<Action>

    fun setLeftButtonJustPressed(function: () -> Unit)
    fun setRightButtonJustPressed(function: () -> Unit)
    fun setCenterButtonJustPressed(function: () -> Unit)

}