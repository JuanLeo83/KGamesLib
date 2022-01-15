package kgames.core.render

import org.joml.Matrix4f


class TileSheet(
    filePath: String,
    private val amountOfTiles: Int
) {

    private val texture: Texture = Texture(filePath)
    private val scale = Matrix4f().scale(1.0f / amountOfTiles.toFloat())
    private val translation = Matrix4f()

    fun bindTile(shader: Shader, x: Int, y: Int) {
        scale.translate(x.toFloat(), y.toFloat(), 0f, translation)
        shader.setUniform("sampler", 0)
        shader.setUniform("texModifier", translation)
        texture.bind(0)
    }

    fun bindTile(shader: Shader, tile: Int) {
        val x = tile % amountOfTiles
        val y = tile / amountOfTiles
        bindTile(shader, x, y)
    }

    fun dispose() {
        texture.dispose()
    }
}