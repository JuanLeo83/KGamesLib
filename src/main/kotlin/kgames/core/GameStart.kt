package kgames.core

import kgames.core.audio.AudioManager
import kgames.core.event.emitter.EventEmitterImp
import kgames.core.input.InputManager
import kgames.core.window.WindowManager

fun initGame(
    videoGame: VideoGame,
    width: Int = 800,
    height: Int = 600,
    windowTitle: String = "KGamesLib Hello World :)"
) {
    KGames.width = width
    KGames.height = height
    KGames.windowTitle = windowTitle

    Game(videoGame).start()
}

class KGames {
    companion object {
        var width: Int = 800
        var height: Int = 600
        var windowTitle: String = "KGamesLib Hello World :)"

        val windowManager = WindowManager(width, height, title = windowTitle)
        val inputManager = InputManager(windowManager)
        val audioManager = AudioManager()

        val gameEvents = EventEmitterImp()
    }
}