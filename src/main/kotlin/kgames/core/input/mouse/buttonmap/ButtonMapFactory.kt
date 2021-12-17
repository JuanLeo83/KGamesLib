package kgames.core.input.mouse.buttonmap

import kgames.core.input.mouse.buttonmap.justpressed.ButtonJustPressedImp
import kgames.core.input.mouse.buttonmap.pressed.ButtonPressedImp
import kgames.core.input.mouse.buttonmap.released.ButtonReleasedImp

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