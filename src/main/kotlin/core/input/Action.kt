package core.input

class Action(
    private val key: Int,
    private val state: State,
    private val function: () -> Unit
) {

    fun getKey() = key
    fun getState() = state

    fun execute() {
        function()
    }

}