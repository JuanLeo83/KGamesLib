package kgames.core.window

sealed class AspectRatio(val ratio: Float) {
    object Rw16h10 : AspectRatio(16 / 10f)
    object Rw16h9 : AspectRatio(16 / 9f)
    object Rw4h3 : AspectRatio(4 / 3f)
}