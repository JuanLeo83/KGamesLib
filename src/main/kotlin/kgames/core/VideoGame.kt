package kgames.core

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
//import kgames.core.scene.Scene
import kgames.core.scene.SceneLoader

abstract class VideoGame(
    private val inputManager: InputManager
) {
//    private val sceneDefaultPosition = 0

//    private val scenes = ArrayList<Scene>()
//    protected lateinit var currentScene: Scene

    protected val sceneLoader = SceneLoader()

    abstract fun initialize()
    abstract fun gameLoop()
    abstract fun dispose()

    protected fun setInputs(vararg devices: InputDevice) {
        devices.forEach { device -> device.add(inputManager) }
    }

//    protected fun setScenes(vararg scenes: Scene) {
//        scenes.forEach(::addScene)
//        selectSceneDefault()
//    }
//
//    protected fun addScene(scene: Scene, order: Int? = null) {
//        order?.let {
//            scenes.add(order, scene)
//        } ?: run {
//            scenes.add(scene)
//        }
//        selectSceneDefault()
//    }
//
//    private fun selectSceneDefault() {
//        currentScene = scenes[sceneDefaultPosition]
//    }
}