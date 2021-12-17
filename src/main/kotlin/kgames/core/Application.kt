import kgames.core.Game
import kgames.core.config.WindowManager
import kgames.core.file.FileManager
import kgames.core.input.InputManager

fun main(args: Array<String>) {
    val windowManager = WindowManager()
    val inputManager = InputManager(windowManager)
    val videoGame = GameExample(windowManager, inputManager)

    Game(
        windowManager = windowManager,
        inputManager = inputManager,
        videoGame = videoGame
    ).start()

    FileManager().get("")
}