package kgames.example.scenes.stage3

import kgames.core.render.Texture
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.example.scenes.stage3.input.Stage3InputKeyboard

class Stage3 : Scene() {

    private var sprite: Texture? = null

    override fun setSceneConfig() {
        inputs.add(Stage3InputKeyboard())
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        super.initialize()

        sprite = Texture("sprite/powerball.png")
    }

    override fun update(deltaTime: Double) {
        sprite?.render()
    }

    override fun dispose() {
        super.dispose()

        sprite?.dispose()
    }

}