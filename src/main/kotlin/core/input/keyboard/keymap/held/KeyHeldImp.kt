package core.input.keyboard.keymap.held

import core.input.keyboard.keymap.KeyAction
import org.lwjgl.glfw.GLFW.*

class KeyHeldImp : KeyHeld {

    private val keyActions = ArrayList<KeyAction>()
    override fun getKeyHeldActions() = keyActions

    private fun setKeyHeld(key: Int, function: () -> Unit) {
        keyActions.add(KeyAction(key, GLFW_REPEAT, function))
    }

    override fun setKeyAHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_A, function)
    }

    override fun setKeyBHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_B, function)
    }

    override fun setKeyCHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_C, function)
    }

    override fun setKeyDHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_D, function)
    }

    override fun setKeyEHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_E, function)
    }

    override fun setKeyFHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F, function)
    }

    override fun setKeyGHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_G, function)
    }

    override fun setKeyHHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_H, function)
    }

    override fun setKeyIHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_I, function)
    }

    override fun setKeyJHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_J, function)
    }

    override fun setKeyKHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_K, function)
    }

    override fun setKeyLHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_L, function)
    }

    override fun setKeyMHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_M, function)
    }

    override fun setKeyNHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_N, function)
    }

    override fun setKeyOHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_O, function)
    }

    override fun setKeyPHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_P, function)
    }

    override fun setKeyQHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_Q, function)
    }

    override fun setKeyRHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_R, function)
    }

    override fun setKeySHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_S, function)
    }

    override fun setKeyTHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_T, function)
    }

    override fun setKeyUHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_U, function)
    }

    override fun setKeyVHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_V, function)
    }

    override fun setKeyWHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_W, function)
    }

    override fun setKeyXHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_X, function)
    }

    override fun setKeyYHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_Y, function)
    }

    override fun setKeyZHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_Z, function)
    }

    override fun setKey1Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_1, function)
    }

    override fun setKey2Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_2, function)
    }

    override fun setKey3Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_3, function)
    }

    override fun setKey4Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_4, function)
    }

    override fun setKey5Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_5, function)
    }

    override fun setKey6Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_6, function)
    }

    override fun setKey7Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_7, function)
    }

    override fun setKey8Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_8, function)
    }

    override fun setKey9Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_9, function)
    }

    override fun setKey0Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_0, function)
    }

    override fun setKeyEscHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_ESCAPE, function)
    }

    override fun setKeyF1Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F1, function)
    }

    override fun setKeyF2Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F2, function)
    }

    override fun setKeyF3Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F3, function)
    }

    override fun setKeyF4Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F4, function)
    }

    override fun setKeyF5Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F5, function)
    }

    override fun setKeyF6Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F6, function)
    }

    override fun setKeyF7Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F7, function)
    }

    override fun setKeyF8Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F8, function)
    }

    override fun setKeyF9Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F9, function)
    }

    override fun setKeyF10Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F10, function)
    }

    override fun setKeyF11Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F11, function)
    }

    override fun setKeyF12Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_F12, function)
    }

    override fun setKeyBackslashHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_BACKSLASH, function)
    }

    override fun setKeyApostropheHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_APOSTROPHE, function)
    }

    override fun setKeyRightAltHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT_ALT, function)
    }

    override fun setKeyLeftAltHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT_ALT, function)
    }

    override fun setKeyGraveAccentHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_GRAVE_ACCENT, function)
    }

    override fun setKeyBackspaceHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_BACKSPACE, function)
    }

    override fun setKeyLeftBracketHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT_BRACKET, function)
    }

    override fun setKeyRightBracketHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT_BRACKET, function)
    }

    override fun setKeyCapsLockHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_CAPS_LOCK, function)
    }

    override fun setKeyCommaHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_COMMA, function)
    }

    override fun setKeyLeftControlHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT_CONTROL, function)
    }

    override fun setKeyRightControlHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT_CONTROL, function)
    }

    override fun setKeyDeleteHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_DELETE, function)
    }

    override fun setKeyEnterHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_ENTER, function)
    }

    override fun setKeyEqualHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_EQUAL, function)
    }

    override fun setKeyInsertHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_INSERT, function)
    }

    override fun setKeyLastHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LAST, function)
    }

    override fun setKeyLeftShiftHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT_SHIFT, function)
    }

    override fun setKeyRightShiftHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT_SHIFT, function)
    }

    override fun setKeyLeftSuperHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT_SUPER, function)
    }

    override fun setKeyRightSuperHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT_SUPER, function)
    }

    override fun setKeyNumLockHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_NUM_LOCK, function)
    }

    override fun setKeyScrollLockHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_SCROLL_LOCK, function)
    }

    override fun setKeyMenuHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_MENU, function)
    }

    override fun setKeyMultiplyHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyMinusHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_MINUS, function)
    }

    override fun setKeyPauseHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_PAUSE, function)
    }

    override fun setKeyPrintScreenHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_PRINT_SCREEN, function)
    }

    override fun setKeyPeriodHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_PERIOD, function)
    }

    override fun setKeySemicolonHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_SEMICOLON, function)
    }

    override fun setKeySlashHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_SLASH, function)
    }

    override fun setKeySpaceHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_SPACE, function)
    }

    override fun setKeyTabHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_TAB, function)
    }

    override fun setKeyUnknownHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_UNKNOWN, function)
    }

    override fun setKeyNumeric1Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_1, function)
    }

    override fun setKeyNumeric2Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_2, function)
    }

    override fun setKeyNumeric3Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_3, function)
    }

    override fun setKeyNumeric4Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_4, function)
    }

    override fun setKeyNumeric5Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_5, function)
    }

    override fun setKeyNumeric6Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_6, function)
    }

    override fun setKeyNumeric7Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_7, function)
    }

    override fun setKeyNumeric8Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_8, function)
    }

    override fun setKeyNumeric9Held(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_9, function)
    }

    override fun setKeyNumericAddHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_ADD, function)
    }

    override fun setKeyNumericSubtractHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_SUBTRACT, function)
    }

    override fun setKeyNumericMultiplyHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyNumericDivideHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_DIVIDE, function)
    }

    override fun setKeyNumericEnterHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_ENTER, function)
    }

    override fun setKeyNumericEqualHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_EQUAL, function)
    }

    override fun setKeyNumericDecimalHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_KP_DECIMAL, function)
    }

    override fun setKeyPageDownHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_PAGE_DOWN, function)
    }

    override fun setKeyPageUpHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_PAGE_UP, function)
    }

    override fun setKeyHomeHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_HOME, function)
    }

    override fun setKeyEndHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_END, function)
    }

    override fun setKeyUpHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_UP, function)
    }

    override fun setKeyDownHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_DOWN, function)
    }

    override fun setKeyLeftHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_LEFT, function)
    }

    override fun setKeyRightHeld(function: () -> Unit) {
        setKeyHeld(GLFW_KEY_RIGHT, function)
    }
}