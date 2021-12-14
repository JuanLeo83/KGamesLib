package core.input.keyboard.keymap.release

import core.input.keyboard.keymap.KeyAction
import org.lwjgl.glfw.GLFW.*

class KeyReleaseImp : KeyRelease {

    private val keyActions = ArrayList<KeyAction>()
    override fun getKeyReleaseActions() = keyActions

    private fun setKeyRelease(key: Int, function: () -> Unit) {
        keyActions.add(KeyAction(key, GLFW_RELEASE, function))
    }

    override fun setKeyARelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_A, function)
    }

    override fun setKeyBRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_B, function)
    }

    override fun setKeyCRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_C, function)
    }

    override fun setKeyDRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_D, function)
    }

    override fun setKeyERelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_E, function)
    }

    override fun setKeyFRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F, function)
    }

    override fun setKeyGRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_G, function)
    }

    override fun setKeyHRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_H, function)
    }

    override fun setKeyIRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_I, function)
    }

    override fun setKeyJRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_J, function)
    }

    override fun setKeyKRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_K, function)
    }

    override fun setKeyLRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_L, function)
    }

    override fun setKeyMRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_M, function)
    }

    override fun setKeyNRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_N, function)
    }

    override fun setKeyORelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_O, function)
    }

    override fun setKeyPRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_P, function)
    }

    override fun setKeyQRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_Q, function)
    }

    override fun setKeyRRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_R, function)
    }

    override fun setKeySRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_S, function)
    }

    override fun setKeyTRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_T, function)
    }

    override fun setKeyURelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_U, function)
    }

    override fun setKeyVRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_V, function)
    }

    override fun setKeyWRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_W, function)
    }

    override fun setKeyXRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_X, function)
    }

    override fun setKeyYRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_Y, function)
    }

    override fun setKeyZRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_Z, function)
    }

    override fun setKey1Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_1, function)
    }

    override fun setKey2Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_2, function)
    }

    override fun setKey3Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_3, function)
    }

    override fun setKey4Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_4, function)
    }

    override fun setKey5Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_5, function)
    }

    override fun setKey6Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_6, function)
    }

    override fun setKey7Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_7, function)
    }

    override fun setKey8Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_8, function)
    }

    override fun setKey9Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_9, function)
    }

    override fun setKey0Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_0, function)
    }

    override fun setKeyEscRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_ESCAPE, function)
    }

    override fun setKeyF1Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F1, function)
    }

    override fun setKeyF2Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F2, function)
    }

    override fun setKeyF3Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F3, function)
    }

    override fun setKeyF4Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F4, function)
    }

    override fun setKeyF5Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F5, function)
    }

    override fun setKeyF6Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F6, function)
    }

    override fun setKeyF7Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F7, function)
    }

    override fun setKeyF8Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F8, function)
    }

    override fun setKeyF9Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F9, function)
    }

    override fun setKeyF10Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F10, function)
    }

    override fun setKeyF11Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F11, function)
    }

    override fun setKeyF12Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_F12, function)
    }

    override fun setKeyBackslashRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_BACKSLASH, function)
    }

    override fun setKeyApostropheRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_APOSTROPHE, function)
    }

    override fun setKeyRightAltRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT_ALT, function)
    }

    override fun setKeyLeftAltRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT_ALT, function)
    }

    override fun setKeyGraveAccentRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_GRAVE_ACCENT, function)
    }

    override fun setKeyBackspaceRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_BACKSPACE, function)
    }

    override fun setKeyLeftBracketRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT_BRACKET, function)
    }

    override fun setKeyRightBracketRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT_BRACKET, function)
    }

    override fun setKeyCapsLockRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_CAPS_LOCK, function)
    }

    override fun setKeyCommaRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_COMMA, function)
    }

    override fun setKeyLeftControlRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT_CONTROL, function)
    }

    override fun setKeyRightControlRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT_CONTROL, function)
    }

    override fun setKeyDeleteRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_DELETE, function)
    }

    override fun setKeyEnterRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_ENTER, function)
    }

    override fun setKeyEqualRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_EQUAL, function)
    }

    override fun setKeyInsertRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_INSERT, function)
    }

    override fun setKeyLastRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LAST, function)
    }

    override fun setKeyLeftShiftRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT_SHIFT, function)
    }

    override fun setKeyRightShiftRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT_SHIFT, function)
    }

    override fun setKeyLeftSuperRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT_SUPER, function)
    }

    override fun setKeyRightSuperRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT_SUPER, function)
    }

    override fun setKeyNumLockRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_NUM_LOCK, function)
    }

    override fun setKeyScrollLockRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_SCROLL_LOCK, function)
    }

    override fun setKeyMenuRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_MENU, function)
    }

    override fun setKeyMultiplyRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyMinusRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_MINUS, function)
    }

    override fun setKeyPauseRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_PAUSE, function)
    }

    override fun setKeyPrintScreenRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_PRINT_SCREEN, function)
    }

    override fun setKeyPeriodRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_PERIOD, function)
    }

    override fun setKeySemicolonRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_SEMICOLON, function)
    }

    override fun setKeySlashRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_SLASH, function)
    }

    override fun setKeySpaceRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_SPACE, function)
    }

    override fun setKeyTabRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_TAB, function)
    }

    override fun setKeyUnknownRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_UNKNOWN, function)
    }

    override fun setKeyNumeric1Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_1, function)
    }

    override fun setKeyNumeric2Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_2, function)
    }

    override fun setKeyNumeric3Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_3, function)
    }

    override fun setKeyNumeric4Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_4, function)
    }

    override fun setKeyNumeric5Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_5, function)
    }

    override fun setKeyNumeric6Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_6, function)
    }

    override fun setKeyNumeric7Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_7, function)
    }

    override fun setKeyNumeric8Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_8, function)
    }

    override fun setKeyNumeric9Release(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_9, function)
    }

    override fun setKeyNumericAddRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_ADD, function)
    }

    override fun setKeyNumericSubtractRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_SUBTRACT, function)
    }

    override fun setKeyNumericMultiplyRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyNumericDivideRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_DIVIDE, function)
    }

    override fun setKeyNumericEnterRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_ENTER, function)
    }

    override fun setKeyNumericEqualRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_EQUAL, function)
    }

    override fun setKeyNumericDecimalRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_KP_DECIMAL, function)
    }

    override fun setKeyPageDownRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_PAGE_DOWN, function)
    }

    override fun setKeyPageUpRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_PAGE_UP, function)
    }

    override fun setKeyHomeRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_HOME, function)
    }

    override fun setKeyEndRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_END, function)
    }

    override fun setKeyUpRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_UP, function)
    }

    override fun setKeyDownRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_DOWN, function)
    }

    override fun setKeyLeftRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_LEFT, function)
    }

    override fun setKeyRightRelease(function: () -> Unit) {
        setKeyRelease(GLFW_KEY_RIGHT, function)
    }
}