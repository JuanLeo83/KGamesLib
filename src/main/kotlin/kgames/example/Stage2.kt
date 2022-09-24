package kgames.example

import kgames.core.input.InputDevice
import kgames.core.render.Shader
import kgames.core.render.Texture
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig

class Stage2() : Scene() {

    private lateinit var sprite: Texture
    private lateinit var shader: Shader

    private var scale: Float = 0.01f

    override fun setSceneConfig() {
        val inputs = ArrayList<InputDevice>()
        inputs.add(GameMouse())
        inputs.add(GameKeyboard() {
            scale *= 0.99f
            sprite.setScale(scale)
        })
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        super.initialize()

        sprite = Texture("sprite/ship.png")
        sprite.setScale(scale)
    }

    override fun update(deltaTime: Double) {
        sprite.render()
        println("${getFPS(deltaTime)} FPS")
    }

    override fun dispose() {
        super.dispose()

        sprite.dispose()
    }

}