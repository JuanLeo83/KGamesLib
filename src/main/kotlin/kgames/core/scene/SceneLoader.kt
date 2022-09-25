package kgames.core.scene

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver

class SceneLoader : EventObserver {

    private val sceneDefaultPosition = 0

    private val scenes = ArrayList<Scene>()
    var currentScene: Scene? = null

    init {
        KGames.gameEvents.subscribe(this)
    }

    override fun onEvent(gameEvent: GameEvent) {
        when (gameEvent) {
            is GameEvent.NextScene -> nextScene()
            is GameEvent.PreviousScene -> previousScene()
            is GameEvent.SelectScene -> selectScene(gameEvent.sceneName)
        }
    }

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
        currentScene?.initialize()
    }

    fun selectScene(sceneName: String) {
        findScene(sceneName)?.let {
            currentScene?.dispose()
            currentScene = it
            currentScene?.initialize()
        }
    }

    private fun findScene(sceneName: String): Scene? {
        return scenes.find { scene -> scene.sceneName == sceneName }
    }

    private fun nextScene() {
        moveToNeighborScene(Direction.Forward)
    }

    private fun previousScene() {
        moveToNeighborScene(Direction.Backward)
    }

    private fun moveToNeighborScene(direction: Direction) {
        currentScene?.let { current ->
            val currentPosition = scenes.indexOf(current)
            selectSceneByPosition(currentPosition + direction.value)
        }
    }

    private sealed class Direction(var value: Int) {
        object Forward : Direction(1)
        object Backward : Direction(-1)
    }

}