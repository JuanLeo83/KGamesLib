package kgames.core.event

interface GameEvent {
    object GameQuit : GameEvent
    object NextScene : GameEvent
    object PreviousScene : GameEvent
    data class SelectScene(val sceneName: String) : GameEvent
}