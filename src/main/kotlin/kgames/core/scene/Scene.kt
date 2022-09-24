package kgames.core.scene

import kgames.core.DependencyManager
import kgames.core.event.EventEmitter
import kgames.core.event.GameEvent
import kgames.core.input.InputDevice
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

abstract class Scene {

    val sceneName: String = javaClass.simpleName

    protected var sceneConfig: SceneConfig? = null
    protected val inputs = ArrayList<InputDevice>()
    protected val gameEvents = EventEmitter()

    private var coroutineDeferred: Deferred<Nothing>? = null

    abstract fun setSceneConfig()

    open fun initialize() {
        setSceneConfig()
        setInputs()
    }

    protected fun listenEvents(action: (gameEvent: GameEvent) -> Unit) {
        coroutineDeferred = CoroutineScope(Dispatchers.Default).async {
            gameEvents.event.collect {
                if (it is GameEvent.GameQuit) {
                    DependencyManager.windowManager.close()
                } else {
                    action(it)
                }
            }
        }
    }

    abstract fun update(deltaTime: Double)

    open fun dispose() {
        DependencyManager.inputManager.resetInputs()
        coroutineDeferred?.cancel()
    }

    private fun setInputs() {
        check(sceneConfig != null) { "The scene needs a sceneConfig" }
        sceneConfig?.devices?.forEach { device -> device.add(DependencyManager.inputManager) }
    }

    protected fun getFPS(deltaTime: Double): Int {
        return (1 / deltaTime).toInt()
    }

}