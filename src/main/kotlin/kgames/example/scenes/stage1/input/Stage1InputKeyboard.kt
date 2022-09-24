package kgames.example.scenes.stage1.input

import kgames.core.event.EventEmitter
import kgames.core.event.GameEvent
import kgames.core.input.keyboard.Keyboard
import kgames.example.scenes.stage1.Stage1Event

class Stage1InputKeyboard(
    gameEvents: EventEmitter
) : Keyboard() {

    init {
        with(keyMap) {
            setKeyMJustPressed {
                gameEvents.emit(Stage1Event.PlayMusic)
            }

            setKeyBJustPressed {
                gameEvents.emit(Stage1Event.PauseMusic)
            }

            setKeyNJustPressed {
                gameEvents.emit(Stage1Event.StopMusic)
            }

            setKeyEscReleased {
                gameEvents.emit(GameEvent.GameQuit)
            }

            setKey2JustPressed {
                // TODO emit event to change to the stage 2
            }
        }
    }

}