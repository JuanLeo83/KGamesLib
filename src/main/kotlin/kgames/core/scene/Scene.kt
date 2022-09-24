package kgames.core.scene

import kgames.core.DependencyManager

abstract class Scene() {

    protected var sceneConfig: SceneConfig? = null

    abstract fun setSceneConfig()

    open fun initialize() {
        setSceneConfig()
        setInputs()
    }

    abstract fun update(deltaTime: Double)

    open fun dispose() {
        DependencyManager.inputManager.resetInputs()
    }

    private fun setInputs() {
        check(sceneConfig != null) { "The scene need a sceneConfig" }
        sceneConfig?.devices?.forEach { device -> device.add(DependencyManager.inputManager) }
    }

    protected fun getFPS(deltaTime: Double): Int {
        return (1 / deltaTime).toInt()
    }

}