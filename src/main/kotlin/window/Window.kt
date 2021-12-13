package window

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.glfw.GLFWKeyCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL

class Window(
    private val windowTitle: String,
    private val windowDimensions: WindowDimensions,
) {

    private var window: Long? = null

    private var keyCallback: GLFWKeyCallback? = null
    private var errorCallback: GLFWErrorCallback? = null

    fun run() {
        try {
            initialize()
            loop()

            glfwDestroyWindow(window!!);
            keyCallback?.release()
        } finally {
            glfwTerminate()
            errorCallback?.release()
        }
    }

    private fun initialize() {
        setErrorCallback()
        check(glfwInit() == GLFW_TRUE) { "Unable to initialize GLFW" }
        createWindow()
        setKeyCallback()
        glfwShowWindow(window!!)
    }

    private fun setErrorCallback() {
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))
    }

    private fun createWindow() {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        window = glfwCreateWindow(windowDimensions.width, windowDimensions.height, windowTitle, NULL, NULL)
        check(window != NULL) { "Failed to create the GLFW window" }

        setWindowPositionInScreen()
        glfwMakeContextCurrent(window!!)
        glfwSwapInterval(1)
    }

    private fun setWindowPositionInScreen() {
        val vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor())
        glfwSetWindowPos(
            window!!,
            (vidmode.width() - windowDimensions.width) / 2,
            (vidmode.height() - windowDimensions.height) / 2
        )
    }

    private fun setKeyCallback() {
        keyCallback = glfwSetKeyCallback(window!!, object : GLFWKeyCallback() {
            override fun invoke(
                window: kotlin.Long,
                key: kotlin.Int,
                scancode: kotlin.Int,
                action: kotlin.Int,
                mods: kotlin.Int
            ) {
                if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    glfwSetWindowShouldClose(window, GLFW_TRUE)
                }
            }
        })
    }

    private fun loop() {
        GL.createCapabilities()

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f)

        while (glfwWindowShouldClose(window!!) == GLFW_FALSE) {
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
            glfwSwapBuffers(window!!)
            glfwPollEvents()
        }
    }

}