package core.input

import GameKeyboard
import core.config.WindowManager
import core.input.keyboard.InputKeyboard
import org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback
import org.lwjgl.glfw.GLFWCursorPosCallback

class InputManager(
    private val windowManager: WindowManager
) {

    private var mousePositionCallback: GLFWCursorPosCallback? = null

    private val inputs = ArrayList<Input>()

    fun update() {
        inputs.forEach { it.update() }
    }

    fun addKeyboard(gameKeyboard: GameKeyboard) {
        val keyboard = InputKeyboard(windowManager, gameKeyboard.keyMap)
        inputs.add(keyboard)
    }

    fun addMouse() {
        mousePositionCallback = glfwSetCursorPosCallback(
            windowManager.getWindow(),
            InputMouse() {}
        )
    }

    fun dispose() {
        mousePositionCallback?.release()
    }
}