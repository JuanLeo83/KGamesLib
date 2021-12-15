package core.input.mouse

import core.input.mouse.buttonmap.ButtonMapFactory

abstract class Mouse {
    val buttonMap = ButtonMapFactory.getInstance()

    open fun mouseMovementAction(xPosition: Double, yPosition: Double): Unit {}
}