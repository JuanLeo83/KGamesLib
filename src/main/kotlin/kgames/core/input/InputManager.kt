package kgames.core.input

import kgames.core.input.keyboard.InputKeyboard
import kgames.core.input.keyboard.Keyboard
import kgames.core.input.mouse.InputMouse
import kgames.core.input.mouse.Mouse
import kgames.core.window.WindowManager
import org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback
import org.lwjgl.glfw.GLFWCursorPosCallback

class InputManager(
    private val windowManager: WindowManager
) {

    private var mousePositionCallback: GLFWCursorPosCallback? = null

    private val inputs = ArrayList<Input>()
    private val nextInputs = ArrayList<Input>()

    private var isPendingResetInputs: Boolean = false

    fun update() {
        inputs.forEach { it.update() }
        removeInputs()
        addNextInputs()
    }

    fun addKeyboard(gameKeyboard: Keyboard) {
        val keyboard = InputKeyboard(windowManager, gameKeyboard.keyMap)
        nextInputs.add(keyboard)
    }

    fun addMouse(gameMouse: Mouse) {
        val mouse = InputMouse(windowManager, gameMouse.buttonMap, gameMouse::mouseMovementAction)
        mousePositionCallback = glfwSetCursorPosCallback(windowManager.getWindow(), mouse)
        nextInputs.add(mouse)
    }

    fun resetInputs() {
        isPendingResetInputs = true
    }

    private fun removeInputs() {
        if (isPendingResetInputs) {
            inputs.clear()
            isPendingResetInputs = false
        }
    }

    private fun addNextInputs() {
        if (nextInputs.isNotEmpty()) {
            inputs.addAll(nextInputs)
            nextInputs.clear()
        }
    }

    fun dispose() {
        mousePositionCallback?.free()
    }
}