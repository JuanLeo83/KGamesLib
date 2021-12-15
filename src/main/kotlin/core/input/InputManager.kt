package core.input

import core.config.WindowManager
import core.input.keyboard.InputKeyboard
import core.input.keyboard.Keyboard
import core.input.mouse.InputMouse
import core.input.mouse.Mouse
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

    fun addKeyboard(gameKeyboard: Keyboard) {
        val keyboard = InputKeyboard(windowManager, gameKeyboard.keyMap)
        inputs.add(keyboard)
    }

    fun addMouse(gameMouse: Mouse) {
        val mouse = InputMouse(windowManager, gameMouse.buttonMap, gameMouse::mouseMovementAction)
        mousePositionCallback = glfwSetCursorPosCallback(windowManager.getWindow(), mouse)
        inputs.add(mouse)
    }

    fun dispose() {
        mousePositionCallback?.release()
    }
}