package kgames.core.util

import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*

internal object GlUtil {

    internal fun initGraphicSystem() {
        GL.createCapabilities()
        glEnable(GL_TEXTURE_2D)
    }

    internal fun setClearColor(red: Float, green: Float, blue: Float, alpha: Float) {
        glClearColor(red, green, blue, alpha)
    }

    internal fun setClearColor(red: Int, green: Int, blue: Int, alpha: Int) {
        setClearColor(red.toFloat(), green.toFloat(), blue.toFloat(), alpha.toFloat())
    }

    internal fun clearScreen() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
    }

}