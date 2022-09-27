package kgames.core.scene

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver

class SceneLoader : EventObserver {

    private lateinit var sceneProvider: SceneProvider

    var currentScene: Scene? = null

    init {
        KGames.gameEvents.subscribe(this)
    }

    fun setSceneProvider(sceneProvider: SceneProvider) {
        this.sceneProvider = sceneProvider
    }

    override fun onEvent(gameEvent: GameEvent) {
        if (gameEvent is GameEvent.SelectScene) {
            selectScene(gameEvent.sceneName)
        }
    }

    fun selectScene(sceneName: String) {
        val scene = sceneProvider.getScene(sceneName)
        currentScene?.dispose()
        currentScene = scene
        currentScene?.initialize()
    }

}