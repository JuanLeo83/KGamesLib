package kgames.core.window

import kgames.core.window.WindowUtil.getNull
import kgames.core.window.WindowUtil.getPrimaryMonitor
import kgames.core.window.WindowUtil.getVidMode
import org.lwjgl.glfw.GLFW.*

class WindowManager(
    private val windowConfig: WindowConfig = WindowConfig()
) {

    private val windowNull: Long = -1000
    private var window: Long = windowNull

    private var windowWidth: Int = 0
    private var windowHeight: Int = 0

    private val viewport: Viewport = Viewport(windowConfig.aspectRatio)

    init {
        windowWidth = windowConfig.width
        windowHeight = windowConfig.height
    }

    fun getWindow(): Long {
        checkWindow("Window has not been created yet...")
        return window
    }

    fun createWindow() {
        WindowHint(windowConfig)
        checkWindowDimensions()

        window = glfwCreateWindow(
            windowWidth,
            windowHeight,
            windowConfig.title,
            if (windowConfig.fullScreen) getPrimaryMonitor() else getNull(),
            getNull()
        )
        checkWindow("Failed to create the GLFW window")

        WindowResizeCallback(this)
        WindowLocator(window, windowConfig, windowWidth, windowHeight)
        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)

        viewport.setSize(windowWidth, windowHeight)
    }

    fun resize(width: Int, height: Int) {
        windowWidth = width
        windowHeight = height
        viewport.setSize(windowWidth, windowHeight)
        viewport.set()
    }

    fun showWindow() {
        checkWindow("Window has not been created yet...")
        viewport.set()
        glfwShowWindow(window)
    }

    fun isClosingWindow(): Boolean = glfwWindowShouldClose(window)

    fun close() {
        glfwSetWindowShouldClose(window, true)
    }

    fun dispose() {
        glfwDestroyWindow(window)
    }

    private fun checkWindowDimensions() {
        if (windowConfig.fullScreen) {
            getVidMode()?.let {
                windowWidth = it.width()
                windowHeight = it.height()
            }
        }
    }

    private fun checkWindow(errorMessage: String) {
        check(window != getNull() && window != windowNull) { errorMessage }
    }

}