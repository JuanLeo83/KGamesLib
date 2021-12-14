package core.input.keyboard

class KeyAction(
    private val key: Int,
    private val action: Int,
    private val function: () -> Unit
) {

    fun getKey() = key
    fun getAction() = action

    fun execute() {
        function()
    }

}