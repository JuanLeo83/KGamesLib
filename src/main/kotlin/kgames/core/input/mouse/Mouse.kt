package kgames.core.input.mouse

import kgames.core.input.InputDevice
import kgames.core.input.InputManager
import kgames.core.input.mouse.buttonmap.ButtonMapFactory

abstract class Mouse : InputDevice {
    val buttonMap = ButtonMapFactory.getInstance()

    open fun mouseMovementAction(xPosition: Double, yPosition: Double): Unit {}

    override fun add(inputManager: InputManager) {
        inputManager.addMouse(this)
    }
}