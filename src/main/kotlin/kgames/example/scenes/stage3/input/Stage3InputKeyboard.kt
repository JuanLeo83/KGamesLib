package kgames.example.scenes.stage3.input

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.input.keyboard.Keyboard
import kgames.example.scenes.stage2.Stage2

class Stage3InputKeyboard : Keyboard() {

    init {
        with(keyMap) {
            setKey2Pressed {
                KGames.gameEvents.emit(GameEvent.SelectScene(Stage2::class.java.simpleName))
            }

            setKeyEscReleased {
                KGames.gameEvents.emit(GameEvent.GameQuit)
            }
        }
    }
}