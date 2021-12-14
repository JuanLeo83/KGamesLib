package core.input.keyboard

import core.input.keyboard.keymap.KeyAction
import core.input.keyboard.keymap.KeyMap
import org.lwjgl.glfw.GLFWKeyCallback

class InputKeyboard(
    private val keyMap: KeyMap,
) : GLFWKeyCallback() {

    override fun invoke(
        window: kotlin.Long,
        key: kotlin.Int,
        scancode: kotlin.Int,
        action: kotlin.Int,
        mods: kotlin.Int
    ) {
        findKeyAction(key, action)?.execute()
    }

    private fun findKeyAction(key: kotlin.Int, action: kotlin.Int): KeyAction? {
        return keyMap
            .getKeyActions()
            .find { key == it.getKey() && action == it.getAction() }
    }
}