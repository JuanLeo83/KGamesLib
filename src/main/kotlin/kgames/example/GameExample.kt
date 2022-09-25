package kgames.example

import kgames.core.VideoGame
import kgames.example.scenes.stage1.Stage1
import kgames.example.scenes.stage2.Stage2
import kgames.example.scenes.stage3.Stage3

class GameExample : VideoGame() {

    override fun initialize() {
        sceneLoader.addScene(Stage1())
        sceneLoader.addScene(Stage2())
        sceneLoader.addScene(Stage3())

        sceneLoader.selectScene(Stage2::class.java.simpleName)
    }

}