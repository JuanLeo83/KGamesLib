package core.input.keyboard.keymap

import core.input.keyboard.keymap.pressed.KeyPressedImp
import core.input.keyboard.keymap.release.KeyReleaseImp

class KeyMapFactory {

    companion object {
        private var keyMap: KeyMap? = null

        fun getInstance(): KeyMap {
            return keyMap ?: run {
                keyMap = KeyMap(
                    KeyReleaseImp(),
                    KeyPressedImp()
                )
                keyMap as KeyMap
            }
        }

    }
}