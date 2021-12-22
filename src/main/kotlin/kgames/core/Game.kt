package kgames.core

import kgames.core.config.WindowManager
import kgames.core.input.InputManager
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*

class Game(
    private val windowManager: WindowManager,
    private val inputManager: InputManager,
    private val videoGame: VideoGame
) {
    private var errorCallback: GLFWErrorCallback? = null

    fun start() {
        initialize() { videoGame.initialize() }
        loop() { videoGame.gameLoop() }
        dispose() { videoGame.dispose() }
    }

    private fun initialize(gameInit: () -> Unit) {
        setErrorCallback()
        check(glfwInit()) { "Unable to initialize GLFW" }
        createWindow()

        gameInit()

        glfwShowWindow(windowManager.getWindow())
    }

    private fun setErrorCallback() {
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))
    }

    private fun createWindow() {
        windowManager.createWindow()
    }

    private fun loop(gameLoop: () -> Unit) {
        GL.createCapabilities()

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f)

        while (!glfwWindowShouldClose(windowManager.getWindow())) {
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)

            inputManager.update()

            gameLoop()

            glfwSwapBuffers(windowManager.getWindow())
            glfwPollEvents()
        }
    }

    private fun dispose(gameDispose: () -> Unit) {
        gameDispose()

        inputManager.dispose()

        glfwDestroyWindow(windowManager.getWindow())

        glfwTerminate()
        errorCallback?.free()
    }

}