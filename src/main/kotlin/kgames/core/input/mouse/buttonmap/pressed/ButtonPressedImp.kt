package kgames.core.input.mouse.buttonmap.pressed

import kgames.core.input.Action
import kgames.core.input.State
import org.lwjgl.glfw.GLFW.*

class ButtonPressedImp : ButtonPressed {

    private val buttonActions = ArrayList<Action>()
    override fun getButtonPressedActions() = buttonActions

    private fun setButtonPressed(button: Int, function: () -> Unit) {
        buttonActions.add(Action(button, State.Pressed, function))
    }

    override fun setLeftButtonPressed(function: () -> Unit) {
        setButtonPressed(GLFW_MOUSE_BUTTON_LEFT, function)
    }

    override fun setRightButtonPressed(function: () -> Unit) {
        setButtonPressed(GLFW_MOUSE_BUTTON_RIGHT, function)
    }

    override fun setCenterButtonPressed(function: () -> Unit) {
        setButtonPressed(GLFW_MOUSE_BUTTON_MIDDLE, function)
    }

}