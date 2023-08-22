package kgames.core.window

import kgames.core.window.WindowUtil.getBoolean

data class WindowConfig(
    val title: String = "KGamesLib :)",
    val width: Int = 800,
    val height: Int = 600,
    val fullScreen: Boolean = false,
    val startMaximized: Boolean = false,
    private val resizable: Boolean = true,
    private val decorated: Boolean = true,
    private val alwaysOnTop: Boolean = false,
) {
    fun getResizable(): Int = getBoolean(resizable)

    fun getDecorated(): Int = getBoolean(decorated)

    fun getAlwaysOnTop(): Int = getBoolean(alwaysOnTop)

    fun getStartMaximized(): Int = getBoolean(startMaximized)
}