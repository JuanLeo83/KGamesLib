package kgames.core.window

import org.lwjgl.glfw.GLFW.glfwSetFramebufferSizeCallback

class WindowResizeCallback(windowManager: WindowManager) {
    init {
        glfwSetFramebufferSizeCallback(windowManager.getWindow()) { _: Long, width: Int, height: Int ->
            windowManager.resize(width, height)
        }
    }
}