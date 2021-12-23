package kgames.core.input.mouse

import kgames.core.input.Action
import kgames.core.input.Input
import kgames.core.input.State
import kgames.core.input.mouse.buttonmap.ButtonMap
import kgames.core.window.WindowManager
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWCursorPosCallback

class InputMouse(
    private val windowManager: WindowManager,
    private val buttonMap: ButtonMap,
    private val movementAction: (x: kotlin.Double, y: kotlin.Double) -> Unit
) : GLFWCursorPosCallback(), Input {

    override fun invoke(window: kotlin.Long, xpos: kotlin.Double, ypos: kotlin.Double) {
        movementAction(xpos, ypos)
    }

    private val previousButtonStates = Array<kotlin.Boolean>(GLFW_MOUSE_BUTTON_LAST) { false }
    private val buttons = Array<kotlin.Boolean>(GLFW_MOUSE_BUTTON_LAST) { false }

    override fun update() {
        buttons.forEachIndexed { button, _ ->
            buttons[button] = requestButtonStatus(button)

            getButtonState(button)?.let {
                findButtonAction(button, it)?.execute()
            }

            previousButtonStates[button] = buttons[button]
        }
    }

    private fun getButtonState(button: kotlin.Int): State? {
        return if (isKeyJustPressed(button)) {
            State.JustPressed
        } else if (isKeyPressed(button)) {
            State.Pressed
        } else if (isKeyReleased(button)) {
            State.Released
        } else null
    }

    private fun requestButtonStatus(button: kotlin.Int) = glfwGetMouseButton(
        windowManager.getWindow(), button
    ) == GLFW_PRESS

    private fun isKeyJustPressed(button: kotlin.Int) = buttons[button] && !previousButtonStates[button]

    private fun isKeyPressed(button: kotlin.Int) = buttons[button] && previousButtonStates[button]

    private fun isKeyReleased(button: kotlin.Int) = !buttons[button] && previousButtonStates[button]

    private fun findButtonAction(button: kotlin.Int, state: State): Action? {
        return buttonMap
            .getActions()
            .find { button == it.getKey() && state == it.getState() }
    }


}