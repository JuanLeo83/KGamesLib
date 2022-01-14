package kgames.core.scene

import kgames.core.input.InputManager

class SceneLoader(
    inputManager: InputManager
) {

    private val sceneDefaultPosition = 0

    private val scenes = ArrayList<Scene>()
    lateinit var currentScene: Scene

    fun setScenes(vararg scenes: Scene) {
        scenes.forEach(::addScene)
        selectSceneDefault()
    }

    fun addScene(scene: Scene, order: Int? = null) {
        order?.let {
            scenes.add(order, scene)
        } ?: run {
            scenes.add(scene)
        }
        selectSceneDefault()
    }

    private fun selectSceneDefault() {
        currentScene = scenes[sceneDefaultPosition]
    }

    private fun selectScene(scenePosition: Int) {
        currentScene.dispose()
        currentScene = scenes[scenePosition]
    }

}