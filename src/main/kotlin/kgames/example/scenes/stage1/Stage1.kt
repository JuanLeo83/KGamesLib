package kgames.example.scenes.stage1

import kgames.core.DependencyManager
import kgames.core.audio.Sound
import kgames.core.scene.Scene
import kgames.core.scene.SceneConfig
import kgames.example.scenes.stage1.input.Stage1InputKeyboard
import org.lwjgl.glfw.GLFW
import org.lwjgl.glfw.GLFW.glfwGetFramebufferSize
import org.lwjgl.opengl.GL11
import org.lwjgl.system.MemoryUtil
import java.nio.IntBuffer

class Stage1() : Scene() {

    private var width: IntBuffer = MemoryUtil.memAllocInt(1)
    private var height: IntBuffer = MemoryUtil.memAllocInt(1)

    private lateinit var sound: Sound

    override fun setSceneConfig() {
        inputs.add(Stage1InputKeyboard(sound))
        sceneConfig = SceneConfig(inputs)
    }

    override fun initialize() {
        sound = Sound("audio/sound.ogg", false)
        super.initialize()

        sound.play()
    }

    override fun update(deltaTime: Double) {
        renderTriangle()
    }

    private fun renderTriangle() {
        /* Get width and height to calculate the ratio */
        glfwGetFramebufferSize(DependencyManager.windowManager.getWindow(), width, height)
        val ratio = width.get() / height.get()

        /* Rewind buffers for next get */
        width.rewind()
        height.rewind()

        GL11.glViewport(0, 0, width.get(), height.get())

        /* Set ortographic projection */
        GL11.glMatrixMode(GL11.GL_PROJECTION)
        GL11.glLoadIdentity()
        GL11.glOrtho(-ratio.toDouble(), ratio.toDouble(), -1.0, 1.0, 1.0, -1.0)
        GL11.glMatrixMode(GL11.GL_MODELVIEW)

        /* Rotate matrix */
        GL11.glLoadIdentity()
        GL11.glRotatef(GLFW.glfwGetTime().toFloat() * 50f, 0f, 0f, 1f)

        /* Render triangle */
        GL11.glBegin(GL11.GL_TRIANGLES)
        GL11.glColor3f(1f, 0f, 0f)
        GL11.glVertex3f(-0.6f, -0.4f, 0f)
        GL11.glColor3f(0f, 1f, 0f)
        GL11.glVertex3f(0.6f, -0.4f, 0f)
        GL11.glColor3f(0f, 0f, 1f)
        GL11.glVertex3f(0f, 0.6f, 0f)
        GL11.glEnd()

        /* Flip buffers for next loop */
        width.flip()
        height.flip()
    }

    override fun dispose() {
        super.dispose()

        MemoryUtil.memFree(width)
        MemoryUtil.memFree(height)

        sound.dispose()
    }

}