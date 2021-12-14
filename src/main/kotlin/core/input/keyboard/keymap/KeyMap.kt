package core.input.keyboard.keymap

import core.input.keyboard.keymap.justpressed.KeyJustPressed
import core.input.keyboard.keymap.pressed.KeyPressed
import core.input.keyboard.keymap.released.KeyReleased

class KeyMap(
    private val keyReleased: KeyReleased,
    private val keyJustPressed: KeyJustPressed,
    private val keyPressed: KeyPressed
) : KeyReleased by keyReleased,
    KeyJustPressed by keyJustPressed,
    KeyPressed by keyPressed {

    fun getKeyActions(): List<KeyAction> {
        return keyReleased.getKeyReleaseActions() +
                keyJustPressed.getKeyJustPressedActions() +
                keyPressed.getKeyPressedActions()
    }

}