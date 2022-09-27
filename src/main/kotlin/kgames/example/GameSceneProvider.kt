package kgames.example

import kgames.core.scene.Scene
import kgames.core.scene.SceneProvider
import kgames.example.scenes.stage1.Stage1
import kgames.example.scenes.stage2.Stage2
import kgames.example.scenes.stage3.Stage3

class GameSceneProvider : SceneProvider {

    override fun getScene(sceneName: String): Scene {
        return when (sceneName) {
            "Stage1" -> Stage1()
            "Stage2" -> Stage2()
            "Stage3" -> Stage3()
            else -> Stage1()
        }
    }

}