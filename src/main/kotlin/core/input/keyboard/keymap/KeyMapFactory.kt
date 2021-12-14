package core.input.keyboard.keymap

import core.input.keyboard.keymap.justpressed.KeyJustPressedImp
import core.input.keyboard.keymap.pressed.KeyPressedImp
import core.input.keyboard.keymap.released.KeyReleasedImp

class KeyMapFactory {

    companion object {
        private var keyMap: KeyMap? = null

        fun getInstance(): KeyMap {
            return keyMap ?: run {
                keyMap = KeyMap(
                    KeyReleasedImp(),
                    KeyJustPressedImp(),
                    KeyPressedImp()
                )
                keyMap as KeyMap
            }
        }

    }
}