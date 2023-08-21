package kgames.core.window

import kgames.core.util.GlfwUtil.getBoolean
import kgames.core.util.GlfwUtil.getNull
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWVidMode
import org.lwjgl.system.MemoryUtil

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
            if (windowConfig.fullScreen) glfwGetPrimaryMonitor() else getNull(),
            MemoryUtil.NULL
        )
        checkWindow("Failed to create the GLFW window")

        setWindowPositionInScreen()
        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)
    }

    fun showWindow() {
        checkWindow("Window has not been created yet...")
        glfwShowWindow(window)
    }

    fun close() {
        glfwSetWindowShouldClose(window, true)
    }

    fun dispose() {
        glfwDestroyWindow(window)
    }

    private fun setWindowHints(windowConfig: WindowConfig) {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, getBoolean(windowConfig.resizable))
    }

    private fun setWindowPositionInScreen() {
        if (windowConfig.fullScreen) return

        val vidMode: GLFWVidMode? = glfwGetVideoMode(glfwGetPrimaryMonitor())
        check(vidMode != null) { "VidMode is null" }

        glfwSetWindowPos(
            window, (vidMode.width() - currentWidth) / 2, (vidMode.height() - currentHeight) / 2
        )
    }

    private fun checkWindow(errorMessage: String) {
        check(window != MemoryUtil.NULL && window != windowNull) { errorMessage }
    }

}