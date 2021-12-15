package core.input.keyboard.keymap

import core.input.Action
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

    fun getActions(): List<Action> {
        return keyReleased.getKeyReleasedActions() +
                keyJustPressed.getKeyJustPressedActions() +
                keyPressed.getKeyPressedActions()
    }

}