package core.input.keyboard

import core.input.keyboard.keymap.KeyMapFactory

abstract class Keyboard {
    val keyMap = KeyMapFactory.getInstance()
}