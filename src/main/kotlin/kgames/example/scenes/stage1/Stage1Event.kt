package kgames.example.scenes.stage1

import kgames.core.event.GameEvent

sealed interface Stage1Event {
    object PlayMusic: GameEvent
    object PauseMusic: GameEvent
    object StopMusic: GameEvent
}