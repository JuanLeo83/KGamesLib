package kgames.core

import kgames.core.input.InputManager
import kgames.core.scene.SceneLoader

abstract class VideoGame(
    protected val inputManager: InputManager
) {

    protected val sceneLoader = SceneLoader(inputManager)

    abstract fun initialize()
    abstract fun gameLoop()
    abstract fun dispose()

}