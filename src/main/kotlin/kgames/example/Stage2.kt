package kgames.example

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.render.Texture
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.core.window.WindowManager

class Stage2(
    private val windowManager: WindowManager,
    inputManager: InputManager
) : Scene(inputManager) {

    private lateinit var sprite: Texture

    override fun setSceneConfig() {
        val inputs = ArrayList<InputDevice>()
        inputs.add(GameMouse())
        inputs.add(GameKeyboard(windowManager))
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        super.initialize()

        sprite = Texture("sprite/ship.png")
    }

    override fun update() {
        sprite.bind(0)
        sprite.render()
    }

    override fun dispose() {
        super.dispose()

        sprite.dispose()
    }

}