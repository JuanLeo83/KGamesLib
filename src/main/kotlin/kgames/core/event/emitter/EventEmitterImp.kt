package kgames.core.event.emitter

import kgames.core.event.GameEvent
import kgames.core.event.observer.EventObserver

class EventEmitterImp : EventEmitter {
    private val observers = ArrayList<EventObserver>()
    private val pendingUnsubscribe = ArrayList<EventObserver>()
    private val pendingSubscribers = ArrayList<EventObserver>()

    private var isEmitting: Boolean = false

    override fun subscribe(observer: EventObserver) {
        if (pendingSubscribers.contains(observer)) return

        pendingSubscribers.add(observer)
    }

    override fun unsubscribe(observer: EventObserver) {
        if (pendingUnsubscribe.contains(observer)) return

        pendingUnsubscribe.add(observer)
    }

    override fun emit(gameEvent: GameEvent) {
        isEmitting = true
        observers.forEach { it.onEvent(gameEvent) }
        isEmitting = false
    }

    override fun clear() {
        observers.clear()
    }

    override fun update() {
        if (isEmitting) return

        addPendingSubscribers()
        clearPendingUnsubscribe()
    }

    private fun clearPendingUnsubscribe() {
        if (pendingUnsubscribe.isEmpty()) return

        observers.removeAll(pendingUnsubscribe.toSet())
//        pendingUnsubscribe.forEach { observers.remove(it) }
        pendingUnsubscribe.clear()
    }

    private fun addPendingSubscribers() {
        if (pendingSubscribers.isEmpty()) return

        observers.addAll(pendingSubscribers)
        pendingSubscribers.clear()
    }
}