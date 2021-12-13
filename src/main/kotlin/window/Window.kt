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
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))
        check(glfwInit() == GLFW_TRUE) { "Unable to initialize GLFW window" }

        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)

        window = glfwCreateWindow(windowDimensions.width, windowDimensions.height, windowTitle, NULL, NULL)
        check(window != NULL) { "Failed to create the GLFW window" }

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

        val vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor())
        glfwSetWindowPos(
            window!!,
            (vidmode.width() - windowDimensions.width) / 2,
            (vidmode.height() - windowDimensions.height) / 2
        )
        glfwMakeContextCurrent(window!!)
        glfwSwapInterval(1)
        glfwShowWindow(window!!)
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