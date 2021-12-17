package kgames.core.file

import java.io.File

class FileManager {

    val separator = File.separator

    fun get(fileName: String) {
        val file = File("src/main/resources")

        println(separator)
        println(file.absolutePath)
    }

}