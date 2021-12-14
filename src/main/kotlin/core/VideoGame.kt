package core

interface VideoGame {
    fun initialize()
    fun gameLoop()
    fun dispose()

    fun setInputs()
}