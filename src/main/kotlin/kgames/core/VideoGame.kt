package kgames.core

import kgames.core.scene.SceneLoader

abstract class VideoGame() {

    protected val sceneLoader = SceneLoader(DependencyManager.inputManager)

    abstract fun initialize()

    fun gameLoop(deltaTime: Double) {
        sceneLoader.currentScene.update(deltaTime)
    }

    open fun dispose() {
        sceneLoader.currentScene.dispose()
    }

}