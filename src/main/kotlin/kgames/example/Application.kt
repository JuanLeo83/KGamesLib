import kgames.core.file.KFile
import kgames.core.file.KFolder
import kgames.core.initGame
import kgames.example.GameExample

fun main(args: Array<String>) {
    initGame(GameExample())
//    testFileManager()
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