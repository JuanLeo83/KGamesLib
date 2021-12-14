package core.input

import core.config.WindowManager
import core.input.keyboard.InputKeyboard
import core.input.keyboard.KeyMap
import org.lwjgl.glfw.GLFW.glfwSetCursorPosCallback
import org.lwjgl.glfw.GLFW.glfwSetKeyCallback
import org.lwjgl.glfw.GLFWCursorPosCallback
import org.lwjgl.glfw.GLFWKeyCallback

class InputManager(
    private val windowManager: WindowManager
) {

    private var keyCallback: GLFWKeyCallback? = null
    private var mousePositionCallback: GLFWCursorPosCallback? = null

    fun addKeyboard(keyMap: KeyMap) {
        keyCallback = glfwSetKeyCallback(
            windowManager.getWindow(),
            InputKeyboard(keyMap)
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