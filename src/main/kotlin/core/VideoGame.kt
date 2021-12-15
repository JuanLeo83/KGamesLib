package core

import core.input.InputDevice
import core.input.InputManager

abstract class VideoGame(
    private val inputManager: InputManager
) {
    abstract fun initialize()
    abstract fun gameLoop()
    abstract fun dispose()

    fun setInputs(vararg devices: InputDevice) {
        devices.forEach { device -> device.add(inputManager) }
    }
}