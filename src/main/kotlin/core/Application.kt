import core.Game
import core.config.WindowManager
import core.input.InputManager

fun main(args: Array<String>) {
    val windowManager = WindowManager()
    val inputManager = InputManager(windowManager)
    val videoGame = GameExample(windowManager, inputManager)

    Game(
        windowManager = windowManager,
        inputManager = inputManager,
        videoGame = videoGame
    ).start()
}