import window.Window
import window.WindowDimensions

fun main(args: Array<String>) {
    val windowDimensions = WindowDimensions(800, 600)
    val window = Window(
        windowTitle = "Hola mundo",
        windowDimensions = windowDimensions
    )
    window.run()
}