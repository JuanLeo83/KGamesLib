package kgames.core.input.mouse.buttonmap

import kgames.core.input.Action
import kgames.core.input.mouse.buttonmap.justpressed.ButtonJustPressed
import kgames.core.input.mouse.buttonmap.pressed.ButtonPressed
import kgames.core.input.mouse.buttonmap.released.ButtonReleased

class ButtonMap(
    private val buttonReleased: ButtonReleased,
    private val buttonJustPressed: ButtonJustPressed,
    private val buttonPressed: ButtonPressed
) : ButtonReleased by buttonReleased,
    ButtonJustPressed by buttonJustPressed,
    ButtonPressed by buttonPressed {

    fun getActions(): List<Action> {
        return buttonReleased.getButtonReleasedActions() +
                buttonJustPressed.getButtonJustPressedActions() +
                buttonPressed.getButtonPressedActions()
    }

}