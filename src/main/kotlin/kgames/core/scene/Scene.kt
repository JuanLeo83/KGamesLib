package kgames.core.scene

import kgames.core.KGames
import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver
import kgames.core.input.InputDevice

abstract class Scene : EventObserver {

    val sceneName: String = javaClass.simpleName

    protected var sceneConfig: SceneConfig? = null
    protected val inputs = ArrayList<InputDevice>()

    abstract fun setSceneConfig()

    open fun initialize() {
        KGames.gameEvents.subscribe(this)
        setSceneConfig()
        setInputs()
    }

    override fun onEvent(gameEvent: GameEvent) {
        if (gameEvent is GameEvent.GameQuit) {
            KGames.windowManager.close()
        }
    }

    abstract fun update(deltaTime: Double)

    open fun dispose() {
        KGames.inputManager.resetInputs()
        KGames.gameEvents.unsubscribe(this)
    }

    private fun setInputs() {
        check(sceneConfig != null) { "The scene needs a sceneConfig" }
        sceneConfig?.devices?.forEach { device -> device.add(KGames.inputManager) }
    }

    protected fun getFPS(deltaTime: Double): Int {
        return (1 / deltaTime).toInt()
    }

}