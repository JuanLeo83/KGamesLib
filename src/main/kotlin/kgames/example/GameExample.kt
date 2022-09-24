package kgames.example

import kgames.core.DependencyManager
import kgames.core.VideoGame
import kgames.core.audio.Sound
import kgames.core.input.keyboard.Keyboard
import kgames.core.input.mouse.Mouse


class GameExample() : VideoGame() {

    override fun initialize() {
        sceneLoader.addScene(Stage2())
        sceneLoader.addScene(Stage1())

        sceneLoader.currentScene.initialize()
    }

}

class GameMouse : Mouse() {
    init {
        with(buttonMap) {
            setLeftButtonJustPressed { println("L mouse just pressed") }
            setLeftButtonPressed { println("L mouse pressed") }
            setLeftButtonReleased { println("L mouse released") }

            setCenterButtonJustPressed { println("C mouse just pressed") }

            setRightButtonReleased { println("R mouse just released") }
        }
    }

    override fun mouseMovementAction(xPosition: Double, yPosition: Double) {
//        println("Mouse movement ($xPosition, $yPosition)")
    }
}

class GameKeyboard(
    sound: Sound? = null,
    scale: (() -> Unit)? = null
) : Keyboard() {

    init {
        with(keyMap) {
            setKeyAJustPressed { println("Key A just pressed") }
            setKeyAReleased { println("Key A released") }

            setKeySJustPressed { println("Key S just pressed") }

            setKeyDReleased { println("Key D released") }

            setKeyFPressed { println("Key F pressed") }

            setKeySpaceJustPressed { println("Key SPACE just pressed") }
            setKeySpacePressed { println("Key SPACE pressed") }
            setKeySpaceReleased { println("Key SPACE released") }

            setKeyEscReleased { DependencyManager.windowManager.close() }

            setKeyF7JustPressed {
                if (sound?.isPlaying() == true) {
                    sound.pause()
                } else {
                    sound?.resume()
                }
            }
            setKeyF8JustPressed {
                sound?.stop()
            }

            setKey1Pressed { scale?.let { it() } }
        }
    }

}