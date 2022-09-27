package kgames.example

import kgames.core.VideoGame
import kgames.example.scenes.GameSceneProvider
import kgames.example.scenes.stage2.Stage2

class GameExample : VideoGame() {

    override fun initialize() {
        sceneLoader.setSceneProvider(GameSceneProvider())
        sceneLoader.selectScene(Stage2::class.java.simpleName)
    }

}