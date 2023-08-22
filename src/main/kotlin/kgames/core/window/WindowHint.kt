package kgames.core.window

import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFW.glfwDefaultWindowHints
import org.lwjgl.glfw.GLFW.glfwWindowHint

class WindowHint(windowConfig: WindowConfig) {
    init {
        glfwDefaultWindowHints()
        with(windowConfig) {
            glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE)
            glfwWindowHint(GLFW.GLFW_RESIZABLE, getResizable())
            glfwWindowHint(GLFW.GLFW_DECORATED, getDecorated())
            glfwWindowHint(GLFW.GLFW_FLOATING, getAlwaysOnTop())
            glfwWindowHint(GLFW.GLFW_MAXIMIZED, getStartMaximized())
        }
    }
}