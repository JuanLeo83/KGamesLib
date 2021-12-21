package kgames.core.file

import java.io.File

class KFolder(
    name: String,
    folderPath: String = "",
    duplicatesStrategy: DuplicatesStrategy = DuplicatesStrategy.EXCLUDE
) : FileHandler(name, folderPath, duplicatesStrategy) {

    override fun create(): Boolean {
        return if (!getFolder().mkdir()) {
            manageDuplicate()
        } else true
    }

    override fun initFolder(): File {
        val folder = super.initFolder()
        return File(folder, name)
    }

    override fun cloneWithVariant(variant: String): FileHandler {
        return KFolder(
            "${name}_$variant",
            folderPath,
            duplicatesStrategy
        )
    }

    override fun delete() {
        getFolder().deleteRecursively()
    }

    fun listFiles(): List<FileHandler> {
        val filesInFolder = ArrayList<FileHandler>()
        getFolder().walkTopDown().forEachIndexed { index, it ->
            if (index != 0) {
                if (it.isDirectory) {
                    val kFolder = KFolder(it.name, it.path)
                    filesInFolder.add(kFolder)
                } else if (it.isFile) {
                    val fileName = splitFileNameAndExtension(it.name)
                    val kFile = KFile(fileName.first, fileName.second, it.path)
                    filesInFolder.add(kFile)
                }
            }
        }
        return filesInFolder
    }

    fun splitFileNameAndExtension(fileName: String): Pair<String, String> {
        val dotIndex = fileName.lastIndexOf(".")
        return Pair(
            fileName.substring(0, dotIndex),
            fileName.substring(dotIndex + 1)
        )
    }

}