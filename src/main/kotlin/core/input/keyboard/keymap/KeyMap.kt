package core.input.keyboard.keymap

import core.input.keyboard.keymap.pressed.KeyPressed
import core.input.keyboard.keymap.release.KeyRelease

class KeyMap(
    private val keyRelease: KeyRelease,
    private val keyPressed: KeyPressed
) : KeyRelease by keyRelease,
    KeyPressed by keyPressed {

    fun getKeyActions(): List<KeyAction> {
        return keyRelease.getKeyReleaseActions() +
                keyPressed.getKeyPressedActions()
    }

}