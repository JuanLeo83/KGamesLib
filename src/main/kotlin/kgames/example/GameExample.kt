package kgames.example

import kgames.core.VideoGame
import kgames.core.audio.Sound
import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.input.keyboard.Keyboard
import kgames.core.input.mouse.Mouse
import kgames.core.window.WindowManager


class GameExample(
    private val windowManager: WindowManager,
    inputManager: InputManager
) : VideoGame(inputManager) {

    override fun initialize() {
        val stage1Inputs = ArrayList<InputDevice>()
        stage1Inputs.add(GameKeyboard(windowManager))
        sceneLoader.addScene(
            Stage1(
                windowManager,
                inputManager,

                )
        )

        sceneLoader.currentScene.initialize()
    }

    override fun gameLoop() {
        sceneLoader.currentScene.update()
    }

    override fun dispose() {
        sceneLoader.currentScene.dispose()
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

    override fun mouseMovementAction(xPosition: Double, yPosition: Double): Unit {
//        println("Mouse movement ($xPosition, $yPosition)")
    }
}

class GameKeyboard(
    windowManager: WindowManager,
    sound: Sound? = null
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

            setKeyEscReleased { windowManager.close() }

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
        }
    }

}