package kgames.core.scene

interface SceneProvider {
    fun getScene(sceneName: String): Scene
}