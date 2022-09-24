package kgames.example.scenes.stage1.input

import kgames.core.DependencyManager
import kgames.core.audio.Sound
import kgames.core.input.keyboard.Keyboard

class Stage1InputKeyboard(
    sound: Sound?
) : Keyboard() {

    init {
        with(keyMap) {
            setKeyMJustPressed {
                if (sound?.isPlaying() == true) {
                    sound.pause()
                } else {
                    sound?.resume()
                }
            }

            setKeyNJustPressed {
                sound?.stop()
            }

            setKeyEscReleased { DependencyManager.windowManager.close() }

            setKey2JustPressed {
                // TODO emit event to change to the stage 2
            }
        }
    }

}