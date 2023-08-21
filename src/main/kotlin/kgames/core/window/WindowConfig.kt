package kgames.core.window

data class WindowConfig(
    val title: String = "KGamesLib :)",
    val width: Int = 800,
    val height: Int = 600,
    val resizable: Boolean = false,
    val fullScreen: Boolean = false
)