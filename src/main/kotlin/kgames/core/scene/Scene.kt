package kgames.core.scene

import kgames.core.DependencyManager
import kgames.core.event.EventEmitter
import kgames.core.event.GameEvent
import kgames.core.input.InputDevice
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

abstract class Scene() {

    protected var sceneConfig: SceneConfig? = null
    protected val inputs = ArrayList<InputDevice>()
    protected val gameEvents = EventEmitter()

    abstract fun setSceneConfig()

    open fun initialize() {
        setSceneConfig()
        setInputs()
    }

    protected fun listenEvents(action: (gameEvent: GameEvent) -> Unit) {
        val result = GlobalScope.async {
            gameEvents.event.collect {
                action(it)
            }
        }
    }

    abstract fun update(deltaTime: Double)

    open fun dispose() {
        DependencyManager.inputManager.resetInputs()
    }

    private fun setInputs() {
        check(sceneConfig != null) { "The scene needs a sceneConfig" }
        sceneConfig?.devices?.forEach { device -> device.add(DependencyManager.inputManager) }
    }

    protected fun getFPS(deltaTime: Double): Int {
        return (1 / deltaTime).toInt()
    }

}