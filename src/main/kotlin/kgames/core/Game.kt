package kgames.core

import kgames.core.audio.AudioManager
import kgames.core.input.InputManager
import kgames.core.util.KTime
import kgames.core.window.WindowManager
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*

class Game(
    private val windowManager: WindowManager,
    private val inputManager: InputManager,
    private val audioManager: AudioManager,
    private val videoGame: VideoGame
) {
    private var errorCallback: GLFWErrorCallback? = null

    fun start() {
        initialize() { videoGame.initialize() }
        loop() { deltaTime -> videoGame.gameLoop(deltaTime) }
        dispose() { videoGame.dispose() }
    }

    private fun initialize(gameInit: () -> Unit) {
        setErrorCallback()
        check(glfwInit()) { "Unable to initialize GLFW" }
        createWindow()
        audioManager.init()
        GL.createCapabilities()
        glEnable(GL_TEXTURE_2D)

        gameInit()

        glfwShowWindow(windowManager.getWindow())
    }

    private fun setErrorCallback() {
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))
    }

    private fun createWindow() {
        windowManager.createWindow()
    }

    private fun loop(gameLoop: (deltaTime: Double) -> Unit) {
        var beginTime = KTime.getTime()
        var endTime: Double = 0.0
        var deltaTime: Double = 0.0
        GL.createCapabilities()

        glClearColor(0.0f, 0.0f, 0.0f, 0.0f)

        while (!glfwWindowShouldClose(windowManager.getWindow())) {
            glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)

            inputManager.update()

            gameLoop(deltaTime)

            glfwSwapBuffers(windowManager.getWindow())
            glfwPollEvents()

            endTime = KTime.getTime()
            deltaTime = endTime - beginTime
            beginTime = endTime
        }
    }

    private fun dispose(gameDispose: () -> Unit) {
        gameDispose()

        inputManager.dispose()
        audioManager.dispose()
        windowManager.dispose()

        glfwTerminate()
        errorCallback?.free()
    }

}