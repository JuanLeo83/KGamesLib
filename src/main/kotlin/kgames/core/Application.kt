import kgames.core.Game
import kgames.core.config.WindowManager
import kgames.core.file.KFile
import kgames.core.file.KFolder
import kgames.core.input.InputManager

fun main(args: Array<String>) {
//    initGame()
    testFileManager()
}

fun initGame() {
    val windowManager = WindowManager()
    val inputManager = InputManager(windowManager)
    val videoGame = GameExample(windowManager, inputManager)

    Game(
        windowManager = windowManager,
        inputManager = inputManager,
        videoGame = videoGame
    ).start()
}


fun testFileManager() {

//    val kFile = KFile("aResourceFile", "txt")
//    val content = kFile.loadAsString()
//    println("Original content: $content")
//
//    kFile.write("content of file".toByteArray())
//    println("Result: ${String(kFile.load())}")

//    val anotherFile = KFile("another","file")
//    anotherFile.create()
//    anotherFile.delete()

    val folder = KFolder("aFolder")
    folder.create()
    val file = KFile(folder, "a.file")
    file.create()

    val filesInFolder = folder.listFiles()
    filesInFolder.forEach {
        println(it.getAbsolute())
    }
}