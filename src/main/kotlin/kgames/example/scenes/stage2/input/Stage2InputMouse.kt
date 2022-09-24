package kgames.example.scenes.stage2.input

import kgames.core.input.mouse.Mouse

class Stage2InputMouse : Mouse() {

    init {
        with(buttonMap) {
            setLeftButtonJustPressed { println("L mouse just pressed") }
            setLeftButtonPressed { println("L mouse pressed") }
            setLeftButtonReleased { println("L mouse released") }

            setCenterButtonJustPressed { println("C mouse just pressed") }

            setRightButtonReleased { println("R mouse just released") }
        }
    }

    override fun mouseMovementAction(xPosition: Double, yPosition: Double) {
//        println("Mouse movement ($xPosition, $yPosition)")
    }

}