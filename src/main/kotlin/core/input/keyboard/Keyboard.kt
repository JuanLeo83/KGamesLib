package core.input.keyboard

import core.input.InputDevice
import core.input.InputManager
import core.input.keyboard.keymap.KeyMapFactory

abstract class Keyboard : InputDevice {
    val keyMap = KeyMapFactory.getInstance()

    override fun add(inputManager: InputManager) {
        inputManager.addKeyboard(this)
    }

}