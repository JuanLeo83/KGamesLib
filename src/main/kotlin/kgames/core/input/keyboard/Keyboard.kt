package kgames.core.input.keyboard

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.input.keyboard.keymap.KeyMapFactory

abstract class Keyboard : InputDevice {
    val keyMap = KeyMapFactory.getInstance()

    override fun add(inputManager: InputManager) {
        inputManager.addKeyboard(this)
    }

}