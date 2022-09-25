package kgames.core.event.emitter

import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver

interface EventEmitter {
    val observers: ArrayList<EventObserver>
    val pendingUnsubscribe: ArrayList<EventObserver>
    val pendingSubscribers: ArrayList<EventObserver>

    var isEmitting: Boolean
    var needsCommit: Boolean

    fun subscribe(observer: EventObserver) {
        pendingSubscribers.add(observer)
        needsCommit = true
    }

    fun unsubscribe(observer: EventObserver) {
        pendingUnsubscribe.remove(observer)
        needsCommit = true
    }

    fun emit(gameEvent: GameEvent) {
        isEmitting = true
        observers.forEach { it.onEvent(gameEvent) }
        commit()
        needsCommit = false
        isEmitting = false
    }

    fun clear() {
        observers.clear()
    }

    fun update() {
        if (isEmitting || !needsCommit) return
        commit()
    }

    fun commit() {
        clearPendingUnsubscribe()
        addPendingSubscribers()
    }

    private fun clearPendingUnsubscribe() {
        observers.removeAll(pendingUnsubscribe.toSet())
        pendingUnsubscribe.clear()
    }

    private fun addPendingSubscribers() {
        observers.addAll(pendingSubscribers)
        pendingSubscribers.clear()
    }
}