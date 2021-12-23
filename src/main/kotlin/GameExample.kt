import kgames.core.VideoGame
import kgames.core.audio.Sound
import kgames.core.input.InputManager
import kgames.core.input.keyboard.Keyboard
import kgames.core.input.mouse.Mouse
import kgames.core.window.WindowManager
import org.lwjgl.glfw.GLFW.glfwGetFramebufferSize
import org.lwjgl.glfw.GLFW.glfwGetTime
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil
import java.nio.IntBuffer


class GameExample(
    private val windowManager: WindowManager,
    inputManager: InputManager
) : VideoGame(inputManager) {
    private var width: IntBuffer = MemoryUtil.memAllocInt(1)
    private var height: IntBuffer = MemoryUtil.memAllocInt(1)

    private lateinit var sound: Sound

    override fun initialize() {
        sound = Sound("audio/sound.ogg", false)

        setInputs(
            GameKeyboard(windowManager, sound),
            GameMouse()
        )

        sound.play()
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

        sound.dispose()
    }

}

class GameMouse : Mouse() {
    init {
        with(buttonMap) {
            setLeftButtonJustPressed { println("L mouse just pressed") }
            setLeftButtonPressed { println("L mouse pressed") }
            setLeftButtonReleased { println("L mouse released") }

            setCenterButtonJustPressed { println("C mouse just pressed") }

            setRightButtonReleased { println("R mouse just released") }
        }
    }

    override fun mouseMovementAction(xPosition: Double, yPosition: Double): Unit {
//        println("Mouse movement ($xPosition, $yPosition)")
    }
}

class GameKeyboard(
    windowManager: WindowManager,
    sound: Sound
) : Keyboard() {

    init {
        with(keyMap) {
            setKeyAJustPressed { println("Key A just pressed") }
            setKeyAReleased { println("Key A released") }

            setKeySJustPressed { println("Key S just pressed") }

            setKeyDReleased { println("Key D released") }

            setKeyFPressed { println("Key F pressed") }

            setKeySpaceJustPressed { println("Key SPACE just pressed") }
            setKeySpacePressed { println("Key SPACE pressed") }
            setKeySpaceReleased { println("Key SPACE released") }

            setKeyEscReleased { windowManager.close() }

            setKeyF7JustPressed {
                if (sound.isPlaying()) {
                    sound.pause()
                } else {
                    sound.resume()
                }
            }
            setKeyF8JustPressed {
                sound.stop()
            }
        }
    }

}