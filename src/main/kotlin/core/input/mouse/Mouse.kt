package core.input.mouse

import core.input.InputDevice
import core.input.InputManager
import core.input.mouse.buttonmap.ButtonMapFactory

abstract class Mouse : InputDevice {
    val buttonMap = ButtonMapFactory.getInstance()

    open fun mouseMovementAction(xPosition: Double, yPosition: Double): Unit {}

    override fun add(inputManager: InputManager) {
        inputManager.addMouse(this)
    }
}