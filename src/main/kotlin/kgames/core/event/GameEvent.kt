package kgames.core.event

interface GameEvent {
    object GameQuit : GameEvent
    data class SelectScene(val sceneName: String) : GameEvent
}