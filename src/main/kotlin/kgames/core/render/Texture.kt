package kgames.core.render

import kgames.core.file.KFile
import kgames.core.file.KFolder
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL11.*
import org.lwjgl.opengl.GL13.GL_TEXTURE0
import org.lwjgl.opengl.GL13.glActiveTexture
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memFree
import java.io.File
import java.nio.ByteBuffer
import javax.imageio.ImageIO

class Texture(
    private val filePath: String
) {

    private var textureObject: Int

    private var width: Int
    private var height: Int

    private val pixels: ByteBuffer

    private var scale = 1.0f

    init {
        val file = getFile()
        val bufferedImage = ImageIO.read(file)
        width = bufferedImage.width
        height = bufferedImage.height

        val pixelsRaw = bufferedImage.getRGB(0, 0, width, height, null, 0, width)

        pixels = MemoryUtil.memAlloc(width * height * 4)
        for (i in 0 until width) {
            for (j in 0 until height) {
                val pixel = pixelsRaw[i * width + j]
                pixels.put((pixel shr 16 and 0xFF).toByte()) // red
                pixels.put((pixel shr 8 and 0xFF).toByte()) // green
                pixels.put((pixel and 0xFF).toByte()) // blue
                pixels.put((pixel shr 24 and 0xFF).toByte()) // alpha
            }
        }
        pixels.flip()

        textureObject = glGenTextures()
        glBindTexture(GL_TEXTURE_2D, textureObject)

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST)
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST)
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, pixels)
    }

    private fun getFile(): File {
        val file = KFile(KFolder.getRootFolder(), filePath)
        return file.getFile()
    }

    fun bind(sampler: Int) {
        if (sampler in 0..31) {
            glActiveTexture(GL_TEXTURE0 + sampler)
            glBindTexture(GL_TEXTURE_2D, textureObject)
        }
    }

    fun render() {
        glBegin(GL_QUADS)
        glTexCoord2f(0f, 0f)
        glVertex2f(-scale, scale)
        glTexCoord2f(1f, 0f)
        glVertex2f(scale, scale)
        glTexCoord2f(1f, 1f)
        glVertex2f(scale, -scale)
        glTexCoord2f(0f, 1f)
        glVertex2f(-scale, -scale)
        glEnd()
    }

    fun setScale(scale: Float) {
        this.scale = scale
    }

    fun dispose() {
        glEnable(0)
        glDeleteTextures(textureObject)
        memFree(pixels)
    }

}