package kgames.core.event.emitter

import kgames.core.event.observer.EventObserver

class EventEmitterImp : EventEmitter {
    override val observers = ArrayList<EventObserver>()
    override val pendingUnsubscribe = ArrayList<EventObserver>()
    override val pendingSubscribers =  ArrayList<EventObserver>()

    override var isEmitting: Boolean = false
    override var needsCommit: Boolean = false
}