package kgames.example

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.core.window.WindowManager

class Stage2(
    private val windowManager: WindowManager,
    inputManager: InputManager
) : Scene(inputManager) {

    override fun setSceneConfig() {
        val inputs = ArrayList<InputDevice>()
        inputs.add(GameMouse())
        inputs.add(GameKeyboard(windowManager))
        sceneConfig = SceneConfig(inputs)
    }

    override fun update() {
        println("Stage 2: update")
    }

}