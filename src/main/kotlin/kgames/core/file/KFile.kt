package kgames.core.file

import java.io.File

fun KFile(
    kFolder: KFolder,
    name: String,
    duplicatesStrategy: DuplicatesStrategy = DuplicatesStrategy.EXCLUDE
): KFile {
    val fileName = kFolder.splitFileNameAndExtension(name)
    return KFile(
        fileName.first,
        fileName.second,
        kFolder.name,
        duplicatesStrategy
    )
}

class KFile(
    name: String,
    private val extension: String,
    folderPath: String = "",
    duplicatesStrategy: DuplicatesStrategy = DuplicatesStrategy.EXCLUDE
) : FileHandler(name, folderPath, duplicatesStrategy) {

    private val file: File
    fun getFile() = file

    init {
        file = File(getFolder(), "$name.$extension")
    }

    override fun create(): Boolean {
        return if (!file.createNewFile()) {
            manageDuplicate()
        } else true
    }

    override fun cloneWithVariant(variant: String) = KFile(
        "${name}_$variant",
        extension,
        folderPath,
        duplicatesStrategy
    )

    override fun delete() {
        file.delete()
    }

    fun load(): ByteArray {
        check(file.exists() && file.isFile) { "File not found" }
        return file.readBytes()
    }

    fun loadAsString(): String {
        return String(load())
    }

    fun write(content: ByteArray) {
        if (!file.exists()) {
            create()
        }
        file.writeBytes(content)
    }

}