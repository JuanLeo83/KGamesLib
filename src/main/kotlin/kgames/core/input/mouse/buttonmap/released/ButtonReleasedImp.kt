package kgames.core.input.mouse.buttonmap.released

import kgames.core.input.Action
import kgames.core.input.State
import org.lwjgl.glfw.GLFW.*

class ButtonReleasedImp : ButtonReleased {

    private val buttonActions = ArrayList<Action>()
    override fun getButtonReleasedActions() = buttonActions

    private fun setButtonReleased(button: Int, function: () -> Unit) {
        buttonActions.add(Action(button, State.Released, function))
    }

    override fun setLeftButtonReleased(function: () -> Unit) {
        setButtonReleased(GLFW_MOUSE_BUTTON_LEFT, function)
    }

    override fun setRightButtonReleased(function: () -> Unit) {
        setButtonReleased(GLFW_MOUSE_BUTTON_RIGHT, function)
    }

    override fun setCenterButtonReleased(function: () -> Unit) {
        setButtonReleased(GLFW_MOUSE_BUTTON_MIDDLE, function)
    }
}