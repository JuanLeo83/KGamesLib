package kgames.core.scene

import kgames.core.input.InputManager

abstract class Scene(
    private val inputManager: InputManager
) {

    protected var sceneConfig: SceneConfig? = null

    abstract fun setSceneConfig()

    open fun initialize() {
        setSceneConfig()
        setInputs()
    }

    abstract fun update()

    open fun dispose() {
        inputManager.resetInputs()
    }

    private fun setInputs() {
        check(sceneConfig != null) { "The scene need a sceneConfig" }
        sceneConfig?.devices?.forEach { device -> device.add(inputManager) }
    }

}