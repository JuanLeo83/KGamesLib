package kgames.core.event.observer

import kgames.core.event.GameEvent

interface EventObserver {
    fun onEvent(gameEvent: GameEvent)
}