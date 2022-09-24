package kgames.core.event

interface GameEvent {
    object Idle : GameEvent
    object GameQuit : GameEvent
}