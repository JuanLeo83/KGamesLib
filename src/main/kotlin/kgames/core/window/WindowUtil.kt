package kgames.core.window

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.system.MemoryUtil

internal object WindowUtil {
    internal fun initSystem(): Boolean = glfwInit()

    internal fun getPrimaryMonitor(): Long = glfwGetPrimaryMonitor()

    internal fun swapBuffers(window: Long) {
        glfwSwapBuffers(window)
    }

    internal fun pollEvents() {
        glfwPollEvents()
    }

    internal fun terminateSystem() {
        glfwTerminate()
    }

    internal fun getBoolean(value: Boolean): Int = if (value) GLFW_TRUE else GLFW_FALSE

    internal fun getNull(): Long = MemoryUtil.NULL
}
