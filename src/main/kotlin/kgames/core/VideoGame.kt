package kgames.core

import kgames.core.input.InputDevice
import kgames.core.input.InputManager

abstract class VideoGame(
    private val inputManager: InputManager
) {
    abstract fun initialize()
    abstract fun gameLoop()
    abstract fun dispose()

    protected fun setInputs(vararg devices: InputDevice) {
        devices.forEach { device -> device.add(inputManager) }
    }
}