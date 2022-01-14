package kgames.core.input.keyboard.keymap

import kgames.core.input.keyboard.keymap.justpressed.KeyJustPressedImp
import kgames.core.input.keyboard.keymap.pressed.KeyPressedImp
import kgames.core.input.keyboard.keymap.released.KeyReleasedImp

class KeyMapFactory {

    companion object {
        fun getInstance(): KeyMap {
            return KeyMap(
                KeyReleasedImp(),
                KeyJustPressedImp(),
                KeyPressedImp()
            )
        }
    }

}