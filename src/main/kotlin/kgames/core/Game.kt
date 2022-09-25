package kgames.core

import kgames.core.util.KTime
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*

class Game(
    private val videoGame: VideoGame
) {
    private val windowManager = KGames.windowManager
    private val inputManager = KGames.inputManager
    private val audioManager = KGames.audioManager

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
        initAudio()
        initGL()
        gameInit()
        showWindow()
    }

    private fun setErrorCallback() {
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))
    }

    private fun createWindow() {
        windowManager.createWindow()
    }

    private fun initAudio() {
        audioManager.init()
    }

    private fun initGL() {
        GL.createCapabilities()
        glEnable(GL_TEXTURE_2D)
    }

    private fun showWindow() {
        glfwShowWindow(windowManager.getWindow())
    }

    private fun loop(gameLoop: (deltaTime: Double) -> Unit) {
        var beginTime = KTime.getTime()
        var endTime = 0.0
        var deltaTime = 0.0
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