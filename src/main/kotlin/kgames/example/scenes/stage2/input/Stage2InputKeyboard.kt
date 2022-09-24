package kgames.example.scenes.stage2.input

import kgames.core.DependencyManager
import kgames.core.input.keyboard.Keyboard

class Stage2InputKeyboard(
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

            setKey1Pressed { scale?.let { it() } }

            setKey1JustPressed {
                // TODO emit event to change to the stage 1
            }
        }
    }
}