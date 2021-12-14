package core.input.keyboard

import core.config.WindowManager
import core.input.Input
import core.input.keyboard.keymap.KeyAction
import core.input.keyboard.keymap.KeyMap
import org.lwjgl.glfw.GLFW.*

class InputKeyboard(
    private val windowManager: WindowManager,
    private val keyMap: KeyMap,
) : Input {

    private val previousKeyStates = Array<Boolean>(GLFW_KEY_LAST) { false }
    private val keys = Array<Boolean>(GLFW_KEY_LAST) { false }

    override fun update() {
        keys.forEachIndexed { key, _ ->
            keys[key] = requestKeyStatus(key)

            getKeyState(key)?.let {
                findKeyAction(key, it)?.execute()
            }

            previousKeyStates[key] = keys[key]
        }
    }

    private fun getKeyState(key: Int): KeyState? {
        return if (isKeyJustPressed(key)) {
            KeyState.JustPressed
        } else if (isKeyPressed(key)) {
            KeyState.Pressed
        } else if (isKeyReleased(key)) {
            KeyState.Released
        } else null
    }

    private fun requestKeyStatus(key: Int) = glfwGetKey(windowManager.getWindow(), key) == GLFW_PRESS

    private fun isKeyJustPressed(key: Int) = keys[key] && !previousKeyStates[key]

    private fun isKeyPressed(key: Int) = keys[key] && previousKeyStates[key]

    private fun isKeyReleased(key: Int) = !keys[key] && previousKeyStates[key]

    private fun findKeyAction(key: Int, state: KeyState): KeyAction? {
        return keyMap
            .getKeyActions()
            .find { key == it.getKey() && state.action == it.getAction() }
    }

    sealed class KeyState(val action: Int) {
        object JustPressed : KeyState(GLFW_PRESS)
        object Pressed : KeyState(GLFW_REPEAT)
        object Released : KeyState(GLFW_RELEASE)
    }
}
