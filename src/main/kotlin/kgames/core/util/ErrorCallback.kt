package kgames.core.util

import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFWErrorCallback

class ErrorCallback {
    private val errorCallback: GLFWErrorCallback? = GLFW.glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))

    fun dispose() {
        errorCallback?.free()
    }
}