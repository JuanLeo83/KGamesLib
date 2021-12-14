package core.input.keyboard.keymap

import core.input.keyboard.keymap.held.KeyHeld
import core.input.keyboard.keymap.pressed.KeyPressed
import core.input.keyboard.keymap.released.KeyReleased

class KeyMap(
    private val keyReleased: KeyReleased,
    private val keyPressed: KeyPressed,
    private val keyHeld: KeyHeld
) : KeyReleased by keyReleased,
    KeyPressed by keyPressed,
    KeyHeld by keyHeld {

    fun getKeyActions(): List<KeyAction> {
        return keyReleased.getKeyReleaseActions() +
                keyPressed.getKeyPressedActions() +
                keyHeld.getKeyHeldActions()
    }

}