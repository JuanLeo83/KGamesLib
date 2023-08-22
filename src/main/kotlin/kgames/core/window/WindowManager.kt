package kgames.core.window

import kgames.core.util.GlUtil.setViewPort
import kgames.core.window.WindowUtil.getNull
import kgames.core.window.WindowUtil.getPrimaryMonitor
import org.lwjgl.glfw.GLFW.*

class WindowManager(
    private val windowConfig: WindowConfig = WindowConfig()
) {

    private val windowNull: Long = -1000
    private var window: Long = windowNull

    private var currentWidth: Int = 0
    private var currentHeight: Int = 0

    init {
        currentWidth = windowConfig.width
        currentHeight = windowConfig.height
    }

    fun getWindow(): Long {
        checkWindow("Window has not been created yet...")
        return window
    }

    fun createWindow() {
        setWindowHints(windowConfig)

        window = glfwCreateWindow(
            currentWidth,
            currentHeight,
            windowConfig.title,
            if (windowConfig.fullScreen) getPrimaryMonitor() else getNull(),
            getNull()
        )
        checkWindow("Failed to create the GLFW window")

        setWindowResizeCallback()
        setWindowPositionInScreen()
        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)
    }

    fun resize(width: Int, height: Int) {
        currentWidth = width
        currentHeight = height

        setViewPort(currentWidth, currentHeight)
    }

    fun showWindow() {
        checkWindow("Window has not been created yet...")
        glfwShowWindow(window)
    }

    fun isClosingWindow(): Boolean = glfwWindowShouldClose(window)

    fun close() {
        glfwSetWindowShouldClose(window, true)
    }

    fun dispose() {
        glfwDestroyWindow(window)
    }

    private fun setWindowHints(windowConfig: WindowConfig) {
        glfwDefaultWindowHints()
        with(windowConfig) {
            glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
            glfwWindowHint(GLFW_RESIZABLE, getResizable())
            glfwWindowHint(GLFW_DECORATED, getDecorated())
            glfwWindowHint(GLFW_FLOATING, getAlwaysOnTop())
            glfwWindowHint(GLFW_MAXIMIZED, getStartMaximized())
        }
    }

    private fun setWindowResizeCallback() {
        WindowResizeCallback(this)
    }

    private fun setWindowPositionInScreen() {
        WindowLocator(window, windowConfig, currentWidth, currentHeight)
    }

    private fun checkWindow(errorMessage: String) {
        check(window != getNull() && window != windowNull) { errorMessage }
    }

}