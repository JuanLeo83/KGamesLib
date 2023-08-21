package kgames.core.window

sealed class GameResolution(val resolution: Float) {
    object R16_9 : GameResolution(16 / 9f)
    object R4_3 : GameResolution(4 / 3f)
}