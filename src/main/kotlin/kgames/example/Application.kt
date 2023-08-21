import de.matthiasmann.twl.utils.PNGDecoder
import kgames.core.file.KFile
import kgames.core.file.KFolder
import kgames.core.render.Texture
import org.joml.Matrix4f
import org.joml.Vector4f
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL30.*
import org.lwjgl.stb.STBImage
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import java.nio.ByteBuffer
import java.nio.FloatBuffer
import java.nio.IntBuffer


//fun main() {
//    initGame(GameExample())
//}

//fun main() {
//    GLFWErrorCallback.createPrint(System.err).set()
//
//    if (!glfwInit()) throw IllegalStateException("GLFW can't be initialised")
//
//    println("Version: $GLFW_VERSION_MAJOR.$GLFW_VERSION_MINOR.$GLFW_VERSION_REVISION")
//    println("Version: ${glfwGetVersionString()}")
//
//    glfwDefaultWindowHints()
//    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
//    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)
////    glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, GLFW_TRUE)
//
//
//    val monitor = glfwGetPrimaryMonitor()
//    val mode = glfwGetVideoMode(monitor)
//
//    val width = mode?.width() ?: 800
//    val height = mode?.height() ?: 600
//
//    val window = glfwCreateWindow(800, 600, "Holis", NULL, NULL)
//    if (window == NULL) throw RuntimeException("Failed to create the GLFW window")
//
//    glfwSetKeyCallback(window) { window: Long, key: Int, scancode: Int, action: Int, mods: Int ->
//
////        println("time: ${glfwGetTime()} key: $key, action: $action")
//
//        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
//            glfwSetWindowShouldClose(window, true) // We will detect this in the rendering loop
//        if (key == GLFW_KEY_1 && action == GLFW_RELEASE)
//            glfwSetWindowSize(window, 1920, 1080)
//        if (key == GLFW_KEY_2 && action == GLFW_RELEASE)
//            glfwSetWindowSize(window, 800, 600)
//        if (key == GLFW_KEY_0 && action == GLFW_RELEASE)
//            glfwIconifyWindow(window)
//        if (key == GLFW_KEY_9 && action == GLFW_RELEASE)
//            glfwRequestWindowAttention(window)
//    }
//
//    glfwSetInputMode(window, GLFW_STICKY_KEYS, GLFW_TRUE)
//
////    glfwSetInputMode(window, GLFW_CURSOR, GLFW_CURSOR_HIDDEN)
//
//    glfwSetWindowSizeLimits(window, 300, 300, GLFW_DONT_CARE, GLFW_DONT_CARE)
//
////    glfwSetFramebufferSizeCallback(window) { window: Long, width: Int, height: Int ->
////        println("Size: $width - $height")
////    }
//
//    glfwSetWindowPosCallback(window) { window, x, y ->
//        println("($x, $y)")
//    }
//
//    glfwMakeContextCurrent(window)
//    glfwSwapInterval(1)
//    glfwShowWindow(window)
//
//    GL.createCapabilities()
//    glClearColor(0.0f, 0.0f, 0.0f, 0.0f)
//
//    while (!glfwWindowShouldClose(window)) {
//        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT) // clear the framebuffer
//        glfwSwapBuffers(window) // swap the color buffers
//        glfwPollEvents()
//    }
//
//    glfwDestroyWindow(window)
//    glfwTerminate()
//}

private val fov: Float = Math.toRadians(60.0).toFloat()
private val zNear: Float = 0.01f
private val zFar: Float = 1000f

fun main() {
    GLFWErrorCallback.createPrint(System.err).set()
    if (!glfwInit()) throw IllegalStateException("GLFW can't be initialised")

    glfwDefaultWindowHints()
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3)
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2)

    val window = glfwCreateWindow(800, 600, "Holis", NULL, NULL)
    if (window == NULL) throw RuntimeException("Failed to create the GLFW window")

    glfwSetKeyCallback(window) { window: Long, key: Int, scancode: Int, action: Int, mods: Int ->

        if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
            glfwSetWindowShouldClose(window, true)
    }

    glfwMakeContextCurrent(window)
    glfwSwapInterval(1)
    glfwShowWindow(window)

    GL.createCapabilities()
    glClearColor(0.4f, 0.4f, 0.4f, 0.0f)

    val projectionMatrix = Matrix4f().perspective(fov, 800/600f, zNear, zFar)

    val vsFile = KFile(KFolder.getRootFolder(), "shader/renderingLesson.vert")
    val fsFile = KFile(KFolder.getRootFolder(), "shader/renderingLesson.frag")
    val shaderProgram = MyShaderProgram(
        vsFile.loadAsString(),
        fsFile.loadAsString()
    )
    shaderProgram.createUniform("projectionMatrix")
//    shaderProgram.createUniform("myColor")
    shaderProgram.createUniform("texture_sampler")

    val vertices = floatArrayOf(
        -0.5f,  0.5f, -1.5f,
        -0.5f, -0.5f, -1.5f,
         0.5f, -0.5f, -1.5f,
         0.5f,  0.5f, -1.5f,
    )

    val indices = intArrayOf(0, 1, 3, 3, 1, 2)

    val colours = floatArrayOf(
        0.5f, 0.0f, 0.0f,
        0.0f, 0.5f, 0.0f,
        0.0f, 0.0f, 0.5f,
        0.0f, 0.5f, 0.5f,
    )

    val textureCoords = floatArrayOf(
        0f, 0f,
        0f, 1f,
        1f, 1f,
        1f, 0f
    )


    val file = KFile(KFolder.getRootFolder(), "sprite/ship.png").getFile()
//    val decoder = PNGDecoder(file.inputStream())

//    val buf = ByteBuffer.allocateDirect(4 * decoder.width * decoder.height)
//    decoder.decode(buf, decoder.width * 4, PNGDecoder.Format.RGBA)
//    buf.flip()

    val w: IntBuffer =  memAllocInt(1)
    val h: IntBuffer =  memAllocInt(1)
    val channels: IntBuffer = memAllocInt(1)
    val buf = STBImage.stbi_load(file.absolutePath, w, h, channels, 4)

    val textureId = glGenTextures()
    glBindTexture(GL_TEXTURE_2D, textureId)
    glPixelStorei(GL_UNPACK_ALIGNMENT, 1)
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST)
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST)
    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, w.get(), h.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buf)
    glEnable(GL_BLEND)
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA)

//    glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, decoder.width, decoder.height, 0, GL_RGBA, GL_UNSIGNED_BYTE, buf)
    glGenerateMipmap(GL_TEXTURE_2D)

    val mesh = Mesh(vertices, textureCoords, indices, colours)

//    val texture = Texture("sprite/ship.png")

    glViewport(0, 0, 800, 600)

    while (!glfwWindowShouldClose(window)) {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT) // clear the framebuffer

        render(shaderProgram, mesh, projectionMatrix, textureId)
//        texture.render()

        glfwSwapBuffers(window) // swap the color buffers
        glfwPollEvents()
    }

    shaderProgram.setUniform("texture_mapper", 0)
    shaderProgram.cleanup()
    mesh.cleanup()
    glfwDestroyWindow(window)
    glfwTerminate()
}

fun render(shaderProgram: MyShaderProgram, mesh: Mesh, projectionMatrix: Matrix4f, textureId: Int) {
    shaderProgram.bind()

//    val redValue = (sin(glfwGetTime().toFloat() * 3f) / 2) + 0.5f
//    val greenValue = (sin(glfwGetTime().toFloat() * 5f) / 2) + 0.5f
//    val blueValue = (sin(glfwGetTime().toFloat() * 2f) / 2) + 0.5f
//    shaderProgram.setUniform("myColor", Vector4f(redValue, greenValue, blueValue, 1f))

    shaderProgram.setUniform("projectionMatrix", projectionMatrix)
    shaderProgram.setUniform("texture_mapper", textureId)
    glActiveTexture(GL_TEXTURE0)
    glBindTexture(GL_TEXTURE_2D, textureId)


    glBindVertexArray(mesh.vaoId)
    glEnableVertexAttribArray(0)
    glEnableVertexAttribArray(1)

    glDrawElements(GL_TRIANGLES, mesh.vertexCount, GL_UNSIGNED_INT, 0)

    glDisableVertexAttribArray(0)
    glDisableVertexAttribArray(1)
    glBindVertexArray(0)

    shaderProgram.unbind()
}

class MyShaderProgram(
    vertexShaderCode: String,
    fragmentShaderCode: String
) {
    private val programId: Int
    private val vertexShaderId: Int
    private val fragmentShaderId: Int

    private val uniforms = hashMapOf<String, Int>()

    init {
        programId = glCreateProgram()
        if (programId == 0) throw Exception("Could not create Shader")

        vertexShaderId = createShader(vertexShaderCode, GL_VERTEX_SHADER)
        fragmentShaderId = createShader(fragmentShaderCode, GL_FRAGMENT_SHADER)

        link()
    }

    private fun createShader(shaderCode: String, shaderType: Int): Int {
        val shaderId = glCreateShader(shaderType)
        if (shaderId == 0) throw Exception("Error creating shader. Type: $shaderType")

        glShaderSource(shaderId, shaderCode)
        glCompileShader(shaderId)

        if (glGetShaderi(
                shaderId,
                GL_COMPILE_STATUS
            ) == 0
        ) throw Exception("Error compiling shader code: ${glGetShaderInfoLog(shaderId, 1024)}")

        glAttachShader(programId, shaderId)

        return shaderId
    }

    private fun link() {
        glLinkProgram(programId)
        if (glGetProgrami(
                programId,
                GL_LINK_STATUS
            ) == 0
        ) throw Exception("Error linking shader code: ${glGetProgramInfoLog(programId, 1024)}")

        if (vertexShaderId != 0) glDetachShader(programId, vertexShaderId)
        if (fragmentShaderId != 0) glDetachShader(programId, fragmentShaderId)

        glValidateProgram(programId)
        if (glGetProgrami(programId, GL_VALIDATE_STATUS) == 0) {
            System.err.println("Warning validating shader code: ${glGetProgramInfoLog(programId, 1024)}")
        }
    }

    fun createUniform(uniformName: String) {
        val uniformLocation = glGetUniformLocation(programId, uniformName)
        if (uniformLocation < 0) throw Exception("Could not find uniform: $uniformName")
        uniforms[uniformName] = uniformLocation
    }

    fun setUniform(uniformName: String, value: Matrix4f) {
        uniforms[uniformName]?.let { location ->
            MemoryStack.stackPush().use { stack ->
                glUniformMatrix4fv(location, false, value.get(stack.mallocFloat(16)))
            }
        }
    }

    fun setUniform(uniformName: String, value: Vector4f) {
        uniforms[uniformName]?.let { location ->
            MemoryStack.stackPush().use { stack ->
                glUniform4f(location, value.x, value.y, value.z, value.w)
            }
        }
    }

    fun setUniform(uniformName: String, value: Int) {
        uniforms[uniformName]?.let { location ->
            MemoryStack.stackPush().use { stack ->
                glUniform1i(location, value)
            }
        }
    }

    fun bind() {
        glUseProgram(programId)
    }

    fun unbind() {
        glUseProgram(0)
    }

    fun cleanup() {
        unbind()
        if (programId != 0) glDeleteProgram(programId)
    }

}

class Mesh(positions: FloatArray, textCoords: FloatArray, indices: IntArray, colours: FloatArray) {
    val vaoId: Int
    private val vboId: Int
    private val idxVboId: Int
//    private val colourVboId: Int
    private val textureVboId: Int
    val vertexCount: Int

    init {
        var verticesBuffer: FloatBuffer? = null
        var indicesBuffer: IntBuffer? = null
        var coloursBuffer: FloatBuffer? = null
        var textureBuffer: FloatBuffer? = null
        try {
            verticesBuffer = memAllocFloat(positions.size)
            check(verticesBuffer != null)

            indicesBuffer = memAllocInt(indices.size)
            check(indicesBuffer != null)

            coloursBuffer = memAllocFloat(colours.size)
            check(coloursBuffer != null)

            textureBuffer = memAllocFloat(textCoords.size)
            check(textureBuffer != null)

            vertexCount = indices.size

            verticesBuffer.put(positions).flip()
            indicesBuffer.put(indices).flip()
            coloursBuffer.put(colours).flip()
            textureBuffer.put(textCoords).flip()

            vaoId = glGenVertexArrays()
            glBindVertexArray(vaoId)

            vboId = glGenBuffers()
            glBindBuffer(GL_ARRAY_BUFFER, vboId)
            glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW)
            glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0)

            idxVboId = glGenBuffers()
            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, idxVboId)
            glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW)

//            colourVboId = glGenBuffers()
//            glBindBuffer(GL_ARRAY_BUFFER, colourVboId)
//            glBufferData(GL_ARRAY_BUFFER, coloursBuffer, GL_STATIC_DRAW)
//            glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0)

            textureVboId = glGenBuffers()
            glBindBuffer(GL_ARRAY_BUFFER, textureVboId)
            glBufferData(GL_ARRAY_BUFFER, textureBuffer, GL_STATIC_DRAW)
            glVertexAttribPointer(1, 2, GL_FLOAT, false, 0, 0)

        } finally {
            glBindBuffer(GL_ARRAY_BUFFER, 0)
            glBindVertexArray(0)

            verticesBuffer?.let { memFree(it) }
            indicesBuffer?.let { memFree(it) }
            coloursBuffer?.let { memFree(it) }
        }
    }

    fun cleanup() {
        glDisableVertexAttribArray(0)
        glBindBuffer(GL_ARRAY_BUFFER, 0)
        glDeleteBuffers(vboId)
        glDeleteBuffers(idxVboId)
//        glDeleteBuffers(colourVboId)
        glBindVertexArray(0)
        glDeleteVertexArrays(vaoId)
    }
}