package kgames.core.file

import kgames.core.file.exception.DuplicatedFileException
import java.io.File
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

abstract class FileHandler(
    val name: String,
    protected val folderPath: String,
    val duplicatesStrategy: DuplicatesStrategy = DuplicatesStrategy.EXCLUDE
) {

    companion object {
        private val separator: String = File.separator
        private var resourcesPath: File? = null
    }

    private val folder: File
    fun getFolder() = folder
    fun getPath(): String = folder.absolutePath

    init {
        initResourcesPath()
        folder = initFolder()
    }

    private fun initResourcesPath() {
        if (resourcesPath != null) return

        val path = File("src${separator}main${separator}resources")
        check(path.exists()) {
            "resources folder not found. If you has deleted or moved the folder you can add it again inside the main folder"
        }
        resourcesPath = path
    }

    protected open fun initFolder(): File {
        return File(resourcesPath, folderPath)
    }

    abstract fun create(): Boolean

    protected fun manageDuplicate(): Boolean {
        return when (duplicatesStrategy) {
            DuplicatesStrategy.EXCLUDE -> excludeAction()
            DuplicatesStrategy.FAIL -> failAction()
            DuplicatesStrategy.INCLUDE -> includeAction()
            DuplicatesStrategy.REPLACE -> replaceAction()
        }
    }

    private fun excludeAction(): Boolean {
        println("${getAbsolute()} already exists")
        return false
    }

    open fun getAbsolute() = folderPath.ifEmpty { "/" }

    private fun failAction(): Boolean {
        throw DuplicatedFileException("${getAbsolute()} already exists")
    }

    private fun includeAction(): Boolean {
        val variant = DateTimeFormatter
            .ofPattern("yyyyMMddHHmmss")
            .withZone(ZoneOffset.UTC)
            .format(Instant.now())
        val kFileVariant = cloneWithVariant(variant)
        return kFileVariant.create()
    }

    protected abstract fun cloneWithVariant(variant: String): FileHandler

    private fun replaceAction(): Boolean {
        delete()
        return create()
    }

    abstract fun delete()

}