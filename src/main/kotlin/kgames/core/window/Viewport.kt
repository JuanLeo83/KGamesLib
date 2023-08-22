package kgames.core.window

import org.lwjgl.opengl.GL11

class Viewport(private val aspectRatio: AspectRatio) {
    private var posX: Int = 0
    private var posY: Int = 0
    private var width: Int = 0
    private var height: Int = 0

    fun setSize(windowWidth: Int, windowHeight: Int) {
        val screenRatio = getScreenRatio(windowWidth, windowHeight)
        resetPosition()

        if (screenRatio > aspectRatio.ratio) {
            width = (windowHeight * aspectRatio.ratio).toInt()
            height = windowHeight
            posX = (windowWidth - width) / 2
        } else if (screenRatio == aspectRatio.ratio) {
            width = windowWidth
            height = windowHeight
        } else {
            width = windowWidth
            height = (windowWidth / aspectRatio.ratio).toInt()
            posY = (windowHeight - height) / 2
        }
    }

    fun set(): Unit = GL11.glViewport(posX, posY, width, height)

    private fun getScreenRatio(screenWidth: Int, screenHeight: Int): Float =
        screenWidth.toFloat() / screenHeight.toFloat()

    private fun resetPosition() {
        posX = 0
        posY = 0
    }

    override fun toString(): String {
        return """
           aspectRatio = ${aspectRatio.ratio}
           posX = $posX
           posY = $posY
           width = $width
           height = $height
           currentAspectRatio = ${width.toFloat() / height}
        """
    }
}