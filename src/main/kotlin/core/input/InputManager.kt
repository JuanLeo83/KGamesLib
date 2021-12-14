package core.input

import KeyBoard
import core.config.WindowManager
import core.input.keyboard.InputKeyboard
import org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback
import org.lwjgl.glfw.GLFW.glfwSetKeyCallback
import org.lwjgl.glfw.GLFWCursorPosCallback
import org.lwjgl.glfw.GLFWKeyCallback

class InputManager(
    private val windowManager: WindowManager
) {

    private var keyCallback: GLFWKeyCallback? = null
    private var mousePositionCallback: GLFWCursorPosCallback? = null

    fun addKeyboard(keyBoard: KeyBoard) {
        keyCallback = glfwSetKeyCallback(
            windowManager.getWindow(),
            InputKeyboard(keyBoard.keyMap)
        )
    }

    fun addMouse() {
        mousePositionCallback = glfwSetCursorPosCallback(
            windowManager.getWindow(),
            InputMouse() {}
        )
    }

    fun dispose() {
        keyCallback?.release()
        mousePositionCallback?.release()
    }
}