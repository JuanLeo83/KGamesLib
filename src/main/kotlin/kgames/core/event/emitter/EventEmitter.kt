package kgames.core.event.emitter

import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver

interface EventEmitter {

    fun subscribe(observer: EventObserver)

    fun unsubscribe(observer: EventObserver)

    fun emit(gameEvent: GameEvent)

    fun clear()

    fun update()
}