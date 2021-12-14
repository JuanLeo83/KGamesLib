package core.input.keyboard

import org.lwjgl.glfw.GLFW.*

abstract class KeyMap {

    private val keyActions = ArrayList<KeyAction>()
    fun getKeyActions() = keyActions

    fun setKeyARelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_A, function)
    }

    fun setKeyBRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_B, function)
    }

    fun setKeyEscRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_ESCAPE, function)
    }

    private fun setKeyRelease(key: Int, function: () -> Unit) {
        keyActions.add(KeyAction(key, GLFW_RELEASE, function))
    }

}