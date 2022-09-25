package kgames.example.scenes.stage2

import kgames.core.render.Shader
import kgames.core.render.Texture
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.example.scenes.stage2.input.Stage2InputKeyboard
import kgames.example.scenes.stage2.input.Stage2InputMouse

class Stage2 : Scene() {

    private var sprite: Texture? = null
    private var shader: Shader? = null

    private var scale: Float = 1f

    override fun setSceneConfig() {
        inputs.add(Stage2InputMouse())
        inputs.add(Stage2InputKeyboard {
            scale *= 0.99f
            sprite?.setScale(scale)
        })
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        super.initialize()

        sprite = Texture("sprite/ship.png")
        sprite?.setScale(scale)
    }

    override fun update(deltaTime: Double) {
        sprite?.render()
        println("${getFPS(deltaTime)} FPS")
    }

    override fun dispose() {
        super.dispose()

        sprite?.dispose()
    }

}