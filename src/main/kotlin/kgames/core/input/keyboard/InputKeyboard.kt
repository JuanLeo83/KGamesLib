package kgames.core.input.keyboard

import kgames.core.config.WindowManager
import kgames.core.input.Action
import kgames.core.input.Input
import kgames.core.input.State
import kgames.core.input.keyboard.keymap.KeyMap
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

    private fun getKeyState(key: Int): State? {
        return if (isKeyJustPressed(key)) {
            State.JustPressed
        } else if (isKeyPressed(key)) {
            State.Pressed
        } else if (isKeyReleased(key)) {
            State.Released
        } else null
    }

    private fun requestKeyStatus(key: Int) = glfwGetKey(windowManager.getWindow(), key) == GLFW_PRESS

    private fun isKeyJustPressed(key: Int) = keys[key] && !previousKeyStates[key]

    private fun isKeyPressed(key: Int) = keys[key] && previousKeyStates[key]

    private fun isKeyReleased(key: Int) = !keys[key] && previousKeyStates[key]

    private fun findKeyAction(key: Int, state: State): Action? {
        return keyMap
            .getActions()
            .find { key == it.getKey() && state == it.getState() }
    }

}
