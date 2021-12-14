package core.input

import org.lwjgl.glfw.GLFWCursorPosCallback

class InputMouse(
    private val action: () -> Unit
) : GLFWCursorPosCallback() {
    override fun invoke(window: kotlin.Long, xpos: kotlin.Double, ypos: kotlin.Double) {
        action()
        println("Mouse position -> x: $xpos -- y: $ypos")
    }
}