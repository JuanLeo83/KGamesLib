import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL


fun main() {
    GLFWErrorCallback.createPrint(System.err).set()

    if (!glfwInit()) throw IllegalStateException("GLFW can't be initialised")

    println("Version: $GLFW_VERSION_MAJOR.$GLFW_VERSION_MINOR.$GLFW_VERSION_REVISION")
    println("Version: ${glfwGetVersionString()}")

    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)
//    glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, GLFW_TRUE)


    val monitor = glfwGetPrimaryMonitor()
    val mode = glfwGetVideoMode(monitor)

    val width = mode?.width() ?: 800
    val height = mode?.height() ?: 600

    val window = glfwCreateWindow(800, 600, "Holis", NULL, NULL)
    if (window == NULL) throw RuntimeException("Failed to create the GLFW window")

    glfwSetKeyCallback(window) { window: Long, key: Int, scancode: Int, action: Int, mods: Int ->

//        println("time: ${glfwGetTime()} key: $key, action: $action")

        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
            glfwSetWindowShouldClose(window, true) // We will detect this in the rendering loop
        if (key == GLFW_KEY_1 && action == GLFW_RELEASE)
            glfwSetWindowSize(window, 1920, 1080)
        if (key == GLFW_KEY_2 && action == GLFW_RELEASE)
            glfwSetWindowSize(window, 800, 600)
        if (key == GLFW_KEY_0 && action == GLFW_RELEASE)
            glfwIconifyWindow(window)
        if (key == GLFW_KEY_9 && action == GLFW_RELEASE)
            glfwRequestWindowAttention(window)
    }

    glfwSetInputMode(window, GLFW_STICKY_KEYS, GLFW_TRUE)

//    glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_HIDDEN)

    glfwSetWindowSizeLimits(window, 300, 300, GLFW_DONT_CARE, GLFW_DONT_CARE)

//    glfwSetFramebufferSizeCallback(window) { window: Long, width: Int, height: Int ->
//        println("Size: $width - $height")
//    }

    glfwSetWindowPosCallback(window) { window, x, y ->
        println("($x, $y)")
    }

    glfwMakeContextCurrent(window)
    glfwSwapInterval(1)
    glfwShowWindow(window)

    GL.createCapabilities()
    glClearColor(0.0f, 0.0f, 0.0f, 0.0f)

    while (!glfwWindowShouldClose(window)) {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT) // clear the framebuffer
        glfwSwapBuffers(window) // swap the color buffers
        glfwPollEvents()
    }

    glfwDestroyWindow(window)
    glfwTerminate()
}

