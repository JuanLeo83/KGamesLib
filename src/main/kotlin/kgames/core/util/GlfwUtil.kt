package kgames.core.util

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.system.MemoryUtil

internal object GlfwUtil {
    internal fun initSystem(): Boolean = glfwInit()

    internal fun isGameFinished(window: Long): Boolean = glfwWindowShouldClose(window)

    internal fun swapBuffers(window: Long) {
        glfwSwapBuffers(window)
    }

    internal fun pollEvents() {
        glfwPollEvents()
    }

    internal fun terminate() {
        glfwTerminate()
    }

    internal fun getBoolean(value: Boolean): Int = if (value) GLFW_TRUE else GLFW_FALSE

    internal fun getNull(): Long = MemoryUtil.NULL
}
