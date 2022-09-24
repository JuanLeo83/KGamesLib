package kgames.example

import kgames.core.VideoGame
import kgames.example.scenes.stage1.Stage1
import kgames.example.scenes.stage2.Stage2

class GameExample() : VideoGame() {

    override fun initialize() {
        sceneLoader.addScene(Stage1())
        sceneLoader.addScene(Stage2())

        sceneLoader.currentScene.initialize()
    }

}