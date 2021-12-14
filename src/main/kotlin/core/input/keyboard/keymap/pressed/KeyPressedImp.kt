package core.input.keyboard.keymap.pressed

import core.input.keyboard.keymap.KeyAction
import org.lwjgl.glfw.GLFW.*

class KeyPressedImp : KeyPressed {

    private val keyActions = ArrayList<KeyAction>()
    override fun getKeyPressedActions() = keyActions

    private fun setKeyPressed(key: Int, function: () -> Unit) {
        keyActions.add(KeyAction(key, GLFW_PRESS, function))
    }

    override fun setKeyAPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_A, function)
    }

    override fun setKeyBPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_B, function)
    }

    override fun setKeyCPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_C, function)
    }

    override fun setKeyDPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_D, function)
    }

    override fun setKeyEPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_E, function)
    }

    override fun setKeyFPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F, function)
    }

    override fun setKeyGPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_G, function)
    }

    override fun setKeyHPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_H, function)
    }

    override fun setKeyIPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_I, function)
    }

    override fun setKeyJPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_J, function)
    }

    override fun setKeyKPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_K, function)
    }

    override fun setKeyLPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_L, function)
    }

    override fun setKeyMPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_M, function)
    }

    override fun setKeyNPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_N, function)
    }

    override fun setKeyOPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_O, function)
    }

    override fun setKeyPPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_P, function)
    }

    override fun setKeyQPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_Q, function)
    }

    override fun setKeyRPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_R, function)
    }

    override fun setKeySPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_S, function)
    }

    override fun setKeyTPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_T, function)
    }

    override fun setKeyUPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_U, function)
    }

    override fun setKeyVPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_V, function)
    }

    override fun setKeyWPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_W, function)
    }

    override fun setKeyXPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_X, function)
    }

    override fun setKeyYPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_Y, function)
    }

    override fun setKeyZPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_Z, function)
    }

    override fun setKey1Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_1, function)
    }

    override fun setKey2Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_2, function)
    }

    override fun setKey3Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_3, function)
    }

    override fun setKey4Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_4, function)
    }

    override fun setKey5Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_5, function)
    }

    override fun setKey6Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_6, function)
    }

    override fun setKey7Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_7, function)
    }

    override fun setKey8Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_8, function)
    }

    override fun setKey9Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_9, function)
    }

    override fun setKey0Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_0, function)
    }

    override fun setKeyEscPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_ESCAPE, function)
    }

    override fun setKeyF1Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F1, function)
    }

    override fun setKeyF2Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F2, function)
    }

    override fun setKeyF3Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F3, function)
    }

    override fun setKeyF4Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F4, function)
    }

    override fun setKeyF5Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F5, function)
    }

    override fun setKeyF6Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F6, function)
    }

    override fun setKeyF7Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F7, function)
    }

    override fun setKeyF8Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F8, function)
    }

    override fun setKeyF9Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F9, function)
    }

    override fun setKeyF10Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F10, function)
    }

    override fun setKeyF11Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F11, function)
    }

    override fun setKeyF12Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_F12, function)
    }

    override fun setKeyBackslashPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_BACKSLASH, function)
    }

    override fun setKeyApostrophePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_APOSTROPHE, function)
    }

    override fun setKeyRightAltPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT_ALT, function)
    }

    override fun setKeyLeftAltPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT_ALT, function)
    }

    override fun setKeyGraveAccentPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_GRAVE_ACCENT, function)
    }

    override fun setKeyBackspacePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_BACKSPACE, function)
    }

    override fun setKeyLeftBracketPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT_BRACKET, function)
    }

    override fun setKeyRightBracketPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT_BRACKET, function)
    }

    override fun setKeyCapsLockPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_CAPS_LOCK, function)
    }

    override fun setKeyCommaPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_COMMA, function)
    }

    override fun setKeyLeftControlPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT_CONTROL, function)
    }

    override fun setKeyRightControlPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT_CONTROL, function)
    }

    override fun setKeyDeletePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_DELETE, function)
    }

    override fun setKeyEnterPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_ENTER, function)
    }

    override fun setKeyEqualPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_EQUAL, function)
    }

    override fun setKeyInsertPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_INSERT, function)
    }

    override fun setKeyLastPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LAST, function)
    }

    override fun setKeyLeftShiftPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT_SHIFT, function)
    }

    override fun setKeyRightShiftPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT_SHIFT, function)
    }

    override fun setKeyLeftSuperPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT_SUPER, function)
    }

    override fun setKeyRightSuperPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT_SUPER, function)
    }

    override fun setKeyNumLockPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_NUM_LOCK, function)
    }

    override fun setKeyScrollLockPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_SCROLL_LOCK, function)
    }

    override fun setKeyMenuPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_MENU, function)
    }

    override fun setKeyMultiplyPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyMinusPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_MINUS, function)
    }

    override fun setKeyPausePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_PAUSE, function)
    }

    override fun setKeyPrintScreenPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_PRINT_SCREEN, function)
    }

    override fun setKeyPeriodPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_PERIOD, function)
    }

    override fun setKeySemicolonPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_SEMICOLON, function)
    }

    override fun setKeySlashPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_SLASH, function)
    }

    override fun setKeySpacePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_SPACE, function)
    }

    override fun setKeyTabPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_TAB, function)
    }

    override fun setKeyUnknownPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_UNKNOWN, function)
    }

    override fun setKeyNumeric1Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_1, function)
    }

    override fun setKeyNumeric2Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_2, function)
    }

    override fun setKeyNumeric3Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_3, function)
    }

    override fun setKeyNumeric4Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_4, function)
    }

    override fun setKeyNumeric5Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_5, function)
    }

    override fun setKeyNumeric6Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_6, function)
    }

    override fun setKeyNumeric7Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_7, function)
    }

    override fun setKeyNumeric8Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_8, function)
    }

    override fun setKeyNumeric9Pressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_9, function)
    }

    override fun setKeyNumericAddPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_ADD, function)
    }

    override fun setKeyNumericSubtractPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_SUBTRACT, function)
    }

    override fun setKeyNumericMultiplyPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyNumericDividePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_DIVIDE, function)
    }

    override fun setKeyNumericEnterPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_ENTER, function)
    }

    override fun setKeyNumericEqualPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_EQUAL, function)
    }

    override fun setKeyNumericDecimalPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_KP_DECIMAL, function)
    }

    override fun setKeyPageDownPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_PAGE_DOWN, function)
    }

    override fun setKeyPageUpPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_PAGE_UP, function)
    }

    override fun setKeyHomePressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_HOME, function)
    }

    override fun setKeyEndPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_END, function)
    }

    override fun setKeyUpPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_UP, function)
    }

    override fun setKeyDownPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_DOWN, function)
    }

    override fun setKeyLeftPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_LEFT, function)
    }

    override fun setKeyRightPressed(function: () -> Unit) {
        setKeyPressed(GLFW_KEY_RIGHT, function)
    }
}