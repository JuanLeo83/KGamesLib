package kgames.core.window

import kgames.core.window.WindowUtil.getVidMode
import org.lwjgl.glfw.GLFW.glfwSetWindowPos

class WindowLocator(window: Long, windowConfig: WindowConfig, currentWidth: Int, currentHeight: Int) {
    init {
        if (!windowConfig.fullScreen && !windowConfig.startMaximized) {
            val vidMode = getVidMode()
            check(vidMode != null) { "VidMode is null" }

            glfwSetWindowPos(
                window,
                (vidMode.width() - currentWidth) / 2,
                (vidMode.height() - currentHeight) / 2
            )
        }
    }
}