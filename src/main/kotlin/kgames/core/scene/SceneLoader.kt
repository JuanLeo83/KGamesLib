package kgames.core.scene

class SceneLoader() {

    private val sceneDefaultPosition = 0

    private val scenes = ArrayList<Scene>()
    var currentScene: Scene? = null

    fun addScenes(vararg scenes: Scene) {
        scenes.forEach(::addScene)
        selectSceneDefault()
    }

    fun addScene(scene: Scene, order: Int? = null) {
        order?.let {
            scenes.add(order, scene)
        } ?: run {
            scenes.add(scene)
        }
        selectSceneDefault()
    }

    private fun selectSceneDefault() {
        selectSceneByPosition(sceneDefaultPosition)
    }

    private fun selectSceneByPosition(scenePosition: Int) {
        currentScene?.dispose()
        currentScene = scenes[scenePosition]
    }

    fun selectScene(sceneName: String) {
        findScene(sceneName)?.let {
            currentScene?.dispose()
            currentScene = it
        }
    }

    fun nextScene() {
        moveToNeighborScene(Direction.Forward)
    }

    fun previousScene() {
        moveToNeighborScene(Direction.Backward)
    }

    private fun moveToNeighborScene(direction: Direction) {
        currentScene?.let { current ->
            val currentPosition = scenes.indexOf(current)
            selectSceneByPosition(currentPosition + direction.value)
        }
    }

    private fun findScene(sceneName: String): Scene? {
        return scenes.find { scene -> scene.sceneName == sceneName }
    }

    private sealed class Direction(var value: Int) {
        object Forward : Direction(1)
        object Backward : Direction(-1)
    }

}