package kgames.core

import kgames.core.util.ErrorCallback
import kgames.core.util.GlUtil.clearScreen
import kgames.core.util.GlUtil.initGraphicSystem
import kgames.core.util.GlUtil.setClearColor
import kgames.core.window.WindowUtil.initSystem
import kgames.core.window.WindowUtil.pollEvents
import kgames.core.window.WindowUtil.swapBuffers
import kgames.core.window.WindowUtil.terminateSystem
import kgames.core.util.KTime

class Game(
    private val videoGame: VideoGame
) {
    private val windowManager = KGames.windowManager
    private val inputManager = KGames.inputManager
    private val audioManager = KGames.audioManager

    private lateinit var errorCallback: ErrorCallback

    fun start() {
        initialize() { videoGame.initialize() }
        loop() { deltaTime -> videoGame.gameLoop(deltaTime) }
        dispose() { videoGame.dispose() }
    }

    private fun initialize(gameInit: () -> Unit) {
        setErrorCallback()
        check(initSystem()) { "Unable to initialize GLFW" }
        createWindow()
        initAudio()
        initGraphicSystem()
        gameInit()
        showWindow()
    }

    private fun setErrorCallback() {
        errorCallback = ErrorCallback()
    }

    private fun createWindow() {
        windowManager.createWindow()
    }

    private fun initAudio() {
        audioManager.init()
    }

    private fun showWindow() {
        windowManager.showWindow()
    }

    private fun loop(gameLoop: (deltaTime: Double) -> Unit) {
        var beginTime = KTime.getTime()
        var endTime = 0.0
        var deltaTime = 0.0

        setClearColor(0, 0, 0, 0)

        while (!windowManager.isClosingWindow()) {
            clearScreen()

            inputManager.update()

            gameLoop(deltaTime)

            swapBuffers(windowManager.getWindow())
            pollEvents()

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

        terminateSystem()
        errorCallback.dispose()
    }

}