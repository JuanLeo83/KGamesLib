package kgames.example.scenes.stage2.input

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.input.keyboard.Keyboard
import kgames.example.scenes.stage1.Stage1
import kgames.example.scenes.stage3.Stage3

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

            setKeyEscReleased { KGames.gameEvents.emit(GameEvent.GameQuit) }

            setKeySPressed { scale?.let { it() } }

            setKey1JustPressed {
                KGames.gameEvents.emit(GameEvent.SelectScene(Stage1::class.java.simpleName))
            }

            setKey3JustPressed {
                KGames.gameEvents.emit(GameEvent.SelectScene(Stage3::class.java.simpleName))
            }
        }
    }
}