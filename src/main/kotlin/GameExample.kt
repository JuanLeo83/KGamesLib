import core.VideoGame
import core.config.WindowManager
import core.input.InputManager
import core.input.keyboard.KeyMap
import org.lwjgl.glfw.GLFW.glfwGetFramebufferSize
import org.lwjgl.glfw.GLFW.glfwGetTime
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil
import java.nio.IntBuffer


class GameExample(
    private val windowManager: WindowManager,
    private val inputManager: InputManager
) : VideoGame {
    private var width: IntBuffer = MemoryUtil.memAllocInt(1)
    private var height: IntBuffer = MemoryUtil.memAllocInt(1)

    override fun initialize() {
        TODO("Not yet implemented")
    }

    override fun gameLoop() {
        renderTriangle()
    }

    private fun renderTriangle() {
        /* Get width and height to calculate the ratio */
        glfwGetFramebufferSize(windowManager.getWindow(), width, height)
        val ratio = width.get() / height.get()

        /* Rewind buffers for next get */
        width.rewind()
        height.rewind()

        glViewport(0, 0, width.get(), height.get())

        /* Set ortographic projection */
        glMatrixMode(GL_PROJECTION)
        glLoadIdentity()
        glOrtho(-ratio.toDouble(), ratio.toDouble(), -1.0, 1.0, 1.0, -1.0)
        glMatrixMode(GL_MODELVIEW)

        /* Rotate matrix */
        glLoadIdentity()
        glRotatef(glfwGetTime().toFloat() * 50f, 0f, 0f, 1f)

        /* Render triangle */
        glBegin(GL_TRIANGLES)
        glColor3f(1f, 0f, 0f)
        glVertex3f(-0.6f, -0.4f, 0f)
        glColor3f(0f, 1f, 0f)
        glVertex3f(0.6f, -0.4f, 0f)
        glColor3f(0f, 0f, 1f)
        glVertex3f(0f, 0.6f, 0f)
        glEnd()

        /* Flip buffers for next loop */
        width.flip()
        height.flip()
    }

    override fun dispose() {
        MemoryUtil.memFree(width)
        MemoryUtil.memFree(height)
    }

    override fun setInputs() {
        inputManager.addKeyboard(KeyBoard(windowManager))
//        inputManager.addMouse()
    }

}

class KeyBoard(windowManager: WindowManager) : KeyMap() {
    init {
        setKeyARelease { println("Key A pressed, oh yeah!!!") }
        setKeyBRelease { println("Key B pressed, oh yeah!!!") }
        setKeyEscRelease { windowManager.close() }
    }
}