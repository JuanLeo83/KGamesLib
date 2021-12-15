package core.input.mouse.buttonmap

import core.input.mouse.buttonmap.justpressed.ButtonJustPressedImp
import core.input.mouse.buttonmap.pressed.ButtonPressedImp
import core.input.mouse.buttonmap.released.ButtonReleasedImp

class ButtonMapFactory {

    companion object {
        private var buttonMap: ButtonMap? = null

        fun getInstance(): ButtonMap {
            return buttonMap ?: run {
                buttonMap = ButtonMap(
                    ButtonReleasedImp(),
                    ButtonJustPressedImp(),
                    ButtonPressedImp()
                )
                buttonMap as ButtonMap
            }
        }
    }

}