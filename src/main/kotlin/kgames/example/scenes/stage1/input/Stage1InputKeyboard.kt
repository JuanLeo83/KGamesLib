package kgames.example.scenes.stage1.input

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.input.keyboard.Keyboard
import kgames.example.scenes.stage1.Stage1Event
import kgames.example.scenes.stage2.Stage2

class Stage1InputKeyboard : Keyboard() {

    init {
        with(keyMap) {
            setKeyMJustPressed {
                KGames.gameEvents.emit(Stage1Event.PlayMusic)
            }

            setKeyBJustPressed {
                KGames.gameEvents.emit(Stage1Event.PauseMusic)
            }

            setKeyNJustPressed {
                KGames.gameEvents.emit(Stage1Event.StopMusic)
            }

            setKeyEscReleased {
                KGames.gameEvents.emit(GameEvent.GameQuit)
            }

            setKey2JustPressed {
                KGames.gameEvents.emit(GameEvent.SelectScene(Stage2::class.java.simpleName))
            }
        }
    }

}