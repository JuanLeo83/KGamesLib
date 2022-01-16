package kgames.example

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.render.Shader
import kgames.core.render.Texture
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.core.window.WindowManager

class Stage2(
    private val windowManager: WindowManager,
    inputManager: InputManager
) : Scene(inputManager) {

    private lateinit var sprite: Texture
    private lateinit var shader: Shader

    private var scale: Float = 0.01f

    override fun setSceneConfig() {
        val inputs = ArrayList<InputDevice>()
        inputs.add(GameMouse())
        inputs.add(GameKeyboard(windowManager) {
            scale += 0.001f
            sprite.setScale(scale)
        })
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        super.initialize()

        sprite = Texture("sprite/ship.png")
        sprite.setScale(scale)
    }

    override fun update() {
        sprite.render()
    }

    override fun dispose() {
        super.dispose()

        sprite.dispose()
    }

}