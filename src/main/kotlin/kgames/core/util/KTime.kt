package kgames.core.util

class KTime {

    companion object {
        var timeStarted: Long = System.nanoTime()

        fun getTime(): Double = (System.nanoTime() - timeStarted) * 1E-9
    }
}