package kgames.core.event

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class EventEmitter {

    private val _event = MutableStateFlow<GameEvent>(GameEvent.Idle)
    val event = _event.asStateFlow()

    fun emit(gameEvent: GameEvent) {
        _event.value = gameEvent
    }
}