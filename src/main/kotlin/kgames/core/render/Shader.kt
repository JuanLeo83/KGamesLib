package kgames.core.render

import kgames.core.file.KFile
import kgames.core.file.KFolder
import org.joml.Matrix4f
import org.joml.Vector4f
import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL20.*
import kotlin.system.exitProcess


@Suppress("JoinDeclarationAndAssignment")
class Shader(
    filePath: String
) {

    private val programObject = glCreateProgram()
    private val vertexShaderObject: Int
    private val fragmentShaderObject: Int

    init {
        vertexShaderObject = glCreateShader(GL_VERTEX_SHADER)
        val vsFile = KFile(KFolder.getRootFolder(), "$filePath.vs")
        loadShaderObject(vertexShaderObject, vsFile)

        fragmentShaderObject = glCreateShader(GL_FRAGMENT_SHADER)
        val fsFile = KFile(KFolder.getRootFolder(), "$filePath.fs")
        loadShaderObject(fragmentShaderObject, fsFile)

        glAttachShader(programObject, vertexShaderObject)
        glAttachShader(programObject, fragmentShaderObject)

        glBindAttribLocation(programObject, 0, "vertices")
        glBindAttribLocation(programObject, 1, "textures")

        glLinkProgram(programObject)
        checkCompileStatus(programObject, GL_LINK_STATUS)

        glValidateProgram(programObject)
        checkCompileStatus(programObject, GL_VALIDATE_STATUS)
    }

    private fun loadShaderObject(shaderObject: Int, file: KFile) {
        glShaderSource(shaderObject, file.loadAsString())
        glCompileShader(shaderObject)
        checkCompileStatus(shaderObject, GL_COMPILE_STATUS)
    }

    private fun checkCompileStatus(shaderObject: Int, status: Int) {
        if (glGetShaderi(shaderObject, status) != 1) {
            System.err.println(glGetShaderInfoLog(shaderObject, 1024));
            exitProcess(1)
        }
    }

    fun setUniform(uniformName: String?, value: Int) {
        val location = glGetUniformLocation(programObject, uniformName)
        if (location != -1) {
            glUniform1i(location, value)
        }
    }

    fun setUniform(uniformName: String?, value: Vector4f) {
        val location = glGetUniformLocation(programObject, uniformName)
        if (location != -1) {
            glUniform4f(location, value.x, value.y, value.z, value.w)
        }
    }

    fun setUniform(uniformName: String?, value: Matrix4f) {
        val location = glGetUniformLocation(programObject, uniformName)
        val matrixData = BufferUtils.createFloatBuffer(16)
        value[matrixData]
        if (location != -1) {
            glUniformMatrix4fv(location, false, matrixData)
        }
    }

    fun render() {
        glUseProgram(programObject);
    }

    fun dispose() {
        glDetachShader(programObject, vertexShaderObject)
        glDetachShader(programObject, fragmentShaderObject)
        glDeleteShader(vertexShaderObject)
        glDeleteShader(fragmentShaderObject)
        glDeleteProgram(programObject)
    }

}
