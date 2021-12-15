package core.input

import org.lwjgl.glfw.GLFW

sealed class State(val action: Int) {
    object JustPressed : State(GLFW.GLFW_PRESS)
    object Pressed : State(GLFW.GLFW_REPEAT)
    object Released : State(GLFW.GLFW_RELEASE)
}