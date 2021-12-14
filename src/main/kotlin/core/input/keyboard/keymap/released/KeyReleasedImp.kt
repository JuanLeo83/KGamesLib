package core.input.keyboard.keymap.released

import core.input.keyboard.keymap.KeyAction
import org.lwjgl.glfw.GLFW.*

class KeyReleasedImp : KeyReleased {

    private val keyActions = ArrayList<KeyAction>()
    override fun getKeyReleaseActions() = keyActions

    private fun setKeyReleased(key: Int, function: () -> Unit) {
        keyActions.add(KeyAction(key, GLFW_RELEASE, function))
    }

    override fun setKeyAReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_A, function)
    }

    override fun setKeyBReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_B, function)
    }

    override fun setKeyCReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_C, function)
    }

    override fun setKeyDReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_D, function)
    }

    override fun setKeyEReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_E, function)
    }

    override fun setKeyFReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F, function)
    }

    override fun setKeyGReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_G, function)
    }

    override fun setKeyHReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_H, function)
    }

    override fun setKeyIReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_I, function)
    }

    override fun setKeyJReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_J, function)
    }

    override fun setKeyKReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_K, function)
    }

    override fun setKeyLReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_L, function)
    }

    override fun setKeyMReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_M, function)
    }

    override fun setKeyNReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_N, function)
    }

    override fun setKeyOReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_O, function)
    }

    override fun setKeyPReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_P, function)
    }

    override fun setKeyQReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_Q, function)
    }

    override fun setKeyRReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_R, function)
    }

    override fun setKeySReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_S, function)
    }

    override fun setKeyTReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_T, function)
    }

    override fun setKeyUReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_U, function)
    }

    override fun setKeyVReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_V, function)
    }

    override fun setKeyWReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_W, function)
    }

    override fun setKeyXReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_X, function)
    }

    override fun setKeyYReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_Y, function)
    }

    override fun setKeyZReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_Z, function)
    }

    override fun setKey1Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_1, function)
    }

    override fun setKey2Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_2, function)
    }

    override fun setKey3Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_3, function)
    }

    override fun setKey4Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_4, function)
    }

    override fun setKey5Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_5, function)
    }

    override fun setKey6Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_6, function)
    }

    override fun setKey7Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_7, function)
    }

    override fun setKey8Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_8, function)
    }

    override fun setKey9Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_9, function)
    }

    override fun setKey0Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_0, function)
    }

    override fun setKeyEscReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_ESCAPE, function)
    }

    override fun setKeyF1Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F1, function)
    }

    override fun setKeyF2Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F2, function)
    }

    override fun setKeyF3Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F3, function)
    }

    override fun setKeyF4Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F4, function)
    }

    override fun setKeyF5Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F5, function)
    }

    override fun setKeyF6Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F6, function)
    }

    override fun setKeyF7Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F7, function)
    }

    override fun setKeyF8Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F8, function)
    }

    override fun setKeyF9Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F9, function)
    }

    override fun setKeyF10Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F10, function)
    }

    override fun setKeyF11Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F11, function)
    }

    override fun setKeyF12Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_F12, function)
    }

    override fun setKeyBackslashReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_BACKSLASH, function)
    }

    override fun setKeyApostropheReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_APOSTROPHE, function)
    }

    override fun setKeyRightAltReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT_ALT, function)
    }

    override fun setKeyLeftAltReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT_ALT, function)
    }

    override fun setKeyGraveAccentReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_GRAVE_ACCENT, function)
    }

    override fun setKeyBackspaceReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_BACKSPACE, function)
    }

    override fun setKeyLeftBracketReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT_BRACKET, function)
    }

    override fun setKeyRightBracketReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT_BRACKET, function)
    }

    override fun setKeyCapsLockReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_CAPS_LOCK, function)
    }

    override fun setKeyCommaReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_COMMA, function)
    }

    override fun setKeyLeftControlReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT_CONTROL, function)
    }

    override fun setKeyRightControlReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT_CONTROL, function)
    }

    override fun setKeyDeleteReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_DELETE, function)
    }

    override fun setKeyEnterReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_ENTER, function)
    }

    override fun setKeyEqualReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_EQUAL, function)
    }

    override fun setKeyInsertReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_INSERT, function)
    }

    override fun setKeyLastReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LAST, function)
    }

    override fun setKeyLeftShiftReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT_SHIFT, function)
    }

    override fun setKeyRightShiftReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT_SHIFT, function)
    }

    override fun setKeyLeftSuperReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT_SUPER, function)
    }

    override fun setKeyRightSuperReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT_SUPER, function)
    }

    override fun setKeyNumLockReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_NUM_LOCK, function)
    }

    override fun setKeyScrollLockReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_SCROLL_LOCK, function)
    }

    override fun setKeyMenuReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_MENU, function)
    }

    override fun setKeyMultiplyReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyMinusReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_MINUS, function)
    }

    override fun setKeyPauseReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_PAUSE, function)
    }

    override fun setKeyPrintScreenReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_PRINT_SCREEN, function)
    }

    override fun setKeyPeriodReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_PERIOD, function)
    }

    override fun setKeySemicolonReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_SEMICOLON, function)
    }

    override fun setKeySlashReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_SLASH, function)
    }

    override fun setKeySpaceReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_SPACE, function)
    }

    override fun setKeyTabReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_TAB, function)
    }

    override fun setKeyUnknownReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_UNKNOWN, function)
    }

    override fun setKeyNumeric1Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_1, function)
    }

    override fun setKeyNumeric2Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_2, function)
    }

    override fun setKeyNumeric3Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_3, function)
    }

    override fun setKeyNumeric4Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_4, function)
    }

    override fun setKeyNumeric5Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_5, function)
    }

    override fun setKeyNumeric6Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_6, function)
    }

    override fun setKeyNumeric7Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_7, function)
    }

    override fun setKeyNumeric8Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_8, function)
    }

    override fun setKeyNumeric9Released(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_9, function)
    }

    override fun setKeyNumericAddReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_ADD, function)
    }

    override fun setKeyNumericSubtractReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_SUBTRACT, function)
    }

    override fun setKeyNumericMultiplyReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyNumericDivideReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_DIVIDE, function)
    }

    override fun setKeyNumericEnterReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_ENTER, function)
    }

    override fun setKeyNumericEqualReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_EQUAL, function)
    }

    override fun setKeyNumericDecimalReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_KP_DECIMAL, function)
    }

    override fun setKeyPageDownReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_PAGE_DOWN, function)
    }

    override fun setKeyPageUpReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_PAGE_UP, function)
    }

    override fun setKeyHomeReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_HOME, function)
    }

    override fun setKeyEndReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_END, function)
    }

    override fun setKeyUpReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_UP, function)
    }

    override fun setKeyDownReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_DOWN, function)
    }

    override fun setKeyLeftReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_LEFT, function)
    }

    override fun setKeyRightReleased(function: () -> Unit) {
        setKeyReleased(GLFW_KEY_RIGHT, function)
    }
}