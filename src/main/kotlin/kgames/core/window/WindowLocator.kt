package kgames.core.window

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWVidMode

class WindowLocator(window: Long, windowConfig: WindowConfig, currentWidth: Int, currentHeight: Int) {
    init {
        if (!windowConfig.fullScreen && !windowConfig.startMaximized) {

            val vidMode: GLFWVidMode? = glfwGetVideoMode(glfwGetPrimaryMonitor())
            check(vidMode != null) { "VidMode is null" }

            glfwSetWindowPos(
                window,
                (vidMode.width() - currentWidth) / 2,
                (vidMode.height() - currentHeight) / 2
            )
        }
    }
}