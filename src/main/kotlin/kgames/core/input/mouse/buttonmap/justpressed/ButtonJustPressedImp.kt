package kgames.core.input.mouse.buttonmap.justpressed

import kgames.core.input.Action
import kgames.core.input.State
import org.lwjgl.glfw.GLFW.*

class ButtonJustPressedImp : ButtonJustPressed {

    private val buttonActions = ArrayList<Action>()
    override fun getButtonJustPressedActions() = buttonActions

    private fun setButtonJustPressed(button: Int, function: () -> Unit) {
        buttonActions.add(Action(button, State.JustPressed, function))
    }

    override fun setLeftButtonJustPressed(function: () -> Unit) {
        setButtonJustPressed(GLFW_MOUSE_BUTTON_LEFT, function)
    }

    override fun setRightButtonJustPressed(function: () -> Unit) {
        setButtonJustPressed(GLFW_MOUSE_BUTTON_RIGHT, function)
    }

    override fun setCenterButtonJustPressed(function: () -> Unit) {
        setButtonJustPressed(GLFW_MOUSE_BUTTON_MIDDLE, function)
    }
}