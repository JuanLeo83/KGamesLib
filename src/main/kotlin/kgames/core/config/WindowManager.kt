package kgames.core.config

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWVidMode
import org.lwjgl.system.MemoryUtil

class WindowManager(
    private val width: Int = 800,
    private val height: Int = 600,
    private val title: String = "KGamesLib Hello World :)",
    private val fullScreen: Boolean = false
) {

    private val windowNull: Long = -1000
    private var window: Long = windowNull

    private var actualWidth: Int = 0
    private var actualHeight: Int = 0

    init {
        actualWidth = width
        actualHeight = height
    }

    fun getWindow(): Long {
        checkWindow("Window has not been created yet...")
        return window
    }

    fun getDimensions(): Pair<Int, Int> {
        return Pair(actualWidth, actualHeight)
    }

    fun createWindow() {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        window = glfwCreateWindow(
            actualWidth,
            actualHeight,
            title,
            if (fullScreen) glfwGetPrimaryMonitor() else MemoryUtil.NULL,
            MemoryUtil.NULL
        )
        checkWindow("Failed to create the GLFW window")

        setWindowPositionInScreen()
        glfwMakeContextCurrent(window)
        glfwSwapInterval(1)
    }

    private fun setWindowPositionInScreen() {
        if (!fullScreen) {
            val vidmode: GLFWVidMode? = glfwGetVideoMode(glfwGetPrimaryMonitor())
            check(vidmode != null) { "Vidmode is null" }

            glfwSetWindowPos(
                window,
                (vidmode.width() - actualWidth) / 2,
                (vidmode.height() - actualHeight) / 2
            )
        }
    }

    private fun checkWindow(errorMessage: String) {
        check(window != MemoryUtil.NULL && window != windowNull) { errorMessage }
    }

    fun close() {
        glfwSetWindowShouldClose(window, true)
    }

}