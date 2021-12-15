package core.input.keyboard.keymap.justpressed

import core.input.Action
import core.input.State
import org.lwjgl.glfw.GLFW.*

class KeyJustPressedImp : KeyJustPressed {

    private val keyActions = ArrayList<Action>()
    override fun getKeyJustPressedActions() = keyActions

    private fun setKeyJustPressed(key: Int, function: () -> Unit) {
        keyActions.add(Action(key, State.JustPressed, function))
    }

    override fun setKeyAJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_A, function)
    }

    override fun setKeyBJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_B, function)
    }

    override fun setKeyCJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_C, function)
    }

    override fun setKeyDJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_D, function)
    }

    override fun setKeyEJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_E, function)
    }

    override fun setKeyFJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F, function)
    }

    override fun setKeyGJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_G, function)
    }

    override fun setKeyHJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_H, function)
    }

    override fun setKeyIJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_I, function)
    }

    override fun setKeyJJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_J, function)
    }

    override fun setKeyKJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_K, function)
    }

    override fun setKeyLJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_L, function)
    }

    override fun setKeyMJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_M, function)
    }

    override fun setKeyNJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_N, function)
    }

    override fun setKeyOJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_O, function)
    }

    override fun setKeyPJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_P, function)
    }

    override fun setKeyQJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_Q, function)
    }

    override fun setKeyRJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_R, function)
    }

    override fun setKeySJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_S, function)
    }

    override fun setKeyTJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_T, function)
    }

    override fun setKeyUJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_U, function)
    }

    override fun setKeyVJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_V, function)
    }

    override fun setKeyWJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_W, function)
    }

    override fun setKeyXJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_X, function)
    }

    override fun setKeyYJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_Y, function)
    }

    override fun setKeyZJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_Z, function)
    }

    override fun setKey1JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_1, function)
    }

    override fun setKey2JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_2, function)
    }

    override fun setKey3JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_3, function)
    }

    override fun setKey4JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_4, function)
    }

    override fun setKey5JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_5, function)
    }

    override fun setKey6JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_6, function)
    }

    override fun setKey7JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_7, function)
    }

    override fun setKey8JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_8, function)
    }

    override fun setKey9JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_9, function)
    }

    override fun setKey0JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_0, function)
    }

    override fun setKeyEscJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_ESCAPE, function)
    }

    override fun setKeyF1JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F1, function)
    }

    override fun setKeyF2JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F2, function)
    }

    override fun setKeyF3JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F3, function)
    }

    override fun setKeyF4JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F4, function)
    }

    override fun setKeyF5JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F5, function)
    }

    override fun setKeyF6JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F6, function)
    }

    override fun setKeyF7JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F7, function)
    }

    override fun setKeyF8JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F8, function)
    }

    override fun setKeyF9JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F9, function)
    }

    override fun setKeyF10JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F10, function)
    }

    override fun setKeyF11JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F11, function)
    }

    override fun setKeyF12JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_F12, function)
    }

    override fun setKeyBackslashJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_BACKSLASH, function)
    }

    override fun setKeyApostropheJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_APOSTROPHE, function)
    }

    override fun setKeyRightAltJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT_ALT, function)
    }

    override fun setKeyLeftAltJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT_ALT, function)
    }

    override fun setKeyGraveAccentJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_GRAVE_ACCENT, function)
    }

    override fun setKeyBackspaceJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_BACKSPACE, function)
    }

    override fun setKeyLeftBracketJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT_BRACKET, function)
    }

    override fun setKeyRightBracketJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT_BRACKET, function)
    }

    override fun setKeyCapsLockJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_CAPS_LOCK, function)
    }

    override fun setKeyCommaJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_COMMA, function)
    }

    override fun setKeyLeftControlJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT_CONTROL, function)
    }

    override fun setKeyRightControlJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT_CONTROL, function)
    }

    override fun setKeyDeleteJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_DELETE, function)
    }

    override fun setKeyEnterJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_ENTER, function)
    }

    override fun setKeyEqualJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_EQUAL, function)
    }

    override fun setKeyInsertJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_INSERT, function)
    }

    override fun setKeyLastJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LAST, function)
    }

    override fun setKeyLeftShiftJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT_SHIFT, function)
    }

    override fun setKeyRightShiftJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT_SHIFT, function)
    }

    override fun setKeyLeftSuperJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT_SUPER, function)
    }

    override fun setKeyRightSuperJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT_SUPER, function)
    }

    override fun setKeyNumLockJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_NUM_LOCK, function)
    }

    override fun setKeyScrollLockJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_SCROLL_LOCK, function)
    }

    override fun setKeyMenuJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_MENU, function)
    }

    override fun setKeyMultiplyJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyMinusJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_MINUS, function)
    }

    override fun setKeyPauseJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_PAUSE, function)
    }

    override fun setKeyPrintScreenJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_PRINT_SCREEN, function)
    }

    override fun setKeyPeriodJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_PERIOD, function)
    }

    override fun setKeySemicolonJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_SEMICOLON, function)
    }

    override fun setKeySlashJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_SLASH, function)
    }

    override fun setKeySpaceJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_SPACE, function)
    }

    override fun setKeyTabJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_TAB, function)
    }

    override fun setKeyUnknownJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_UNKNOWN, function)
    }

    override fun setKeyNumeric1JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_1, function)
    }

    override fun setKeyNumeric2JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_2, function)
    }

    override fun setKeyNumeric3JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_3, function)
    }

    override fun setKeyNumeric4JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_4, function)
    }

    override fun setKeyNumeric5JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_5, function)
    }

    override fun setKeyNumeric6JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_6, function)
    }

    override fun setKeyNumeric7JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_7, function)
    }

    override fun setKeyNumeric8JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_8, function)
    }

    override fun setKeyNumeric9JustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_9, function)
    }

    override fun setKeyNumericAddJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_ADD, function)
    }

    override fun setKeyNumericSubtractJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_SUBTRACT, function)
    }

    override fun setKeyNumericMultiplyJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_MULTIPLY, function)
    }

    override fun setKeyNumericDivideJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_DIVIDE, function)
    }

    override fun setKeyNumericEnterJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_ENTER, function)
    }

    override fun setKeyNumericEqualJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_EQUAL, function)
    }

    override fun setKeyNumericDecimalJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_KP_DECIMAL, function)
    }

    override fun setKeyPageDownJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_PAGE_DOWN, function)
    }

    override fun setKeyPageUpJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_PAGE_UP, function)
    }

    override fun setKeyHomeJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_HOME, function)
    }

    override fun setKeyEndJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_END, function)
    }

    override fun setKeyUpJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_UP, function)
    }

    override fun setKeyDownJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_DOWN, function)
    }

    override fun setKeyLeftJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_LEFT, function)
    }

    override fun setKeyRightJustPressed(function: () -> Unit) {
        setKeyJustPressed(GLFW_KEY_RIGHT, function)
    }
}