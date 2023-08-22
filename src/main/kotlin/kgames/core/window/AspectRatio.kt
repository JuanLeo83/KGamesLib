package kgames.core.window

sealed class AspectRatio(val ratio: Float) {
    object R16_9 : AspectRatio(16 / 9f)
    object R4_3 : AspectRatio(4 / 3f)
}