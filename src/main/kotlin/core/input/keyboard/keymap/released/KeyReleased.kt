package core.input.keyboard.keymap.released

import core.input.Action

interface KeyReleased {

    fun getKeyReleasedActions(): List<Action>

    fun setKeyAReleased(function: () -> Unit)
    fun setKeyBReleased(function: () -> Unit)
    fun setKeyCReleased(function: () -> Unit)
    fun setKeyDReleased(function: () -> Unit)
    fun setKeyEReleased(function: () -> Unit)
    fun setKeyFReleased(function: () -> Unit)
    fun setKeyGReleased(function: () -> Unit)
    fun setKeyHReleased(function: () -> Unit)
    fun setKeyIReleased(function: () -> Unit)
    fun setKeyJReleased(function: () -> Unit)
    fun setKeyKReleased(function: () -> Unit)
    fun setKeyLReleased(function: () -> Unit)
    fun setKeyMReleased(function: () -> Unit)
    fun setKeyNReleased(function: () -> Unit)
    fun setKeyOReleased(function: () -> Unit)
    fun setKeyPReleased(function: () -> Unit)
    fun setKeyQReleased(function: () -> Unit)
    fun setKeyRReleased(function: () -> Unit)
    fun setKeySReleased(function: () -> Unit)
    fun setKeyTReleased(function: () -> Unit)
    fun setKeyUReleased(function: () -> Unit)
    fun setKeyVReleased(function: () -> Unit)
    fun setKeyWReleased(function: () -> Unit)
    fun setKeyXReleased(function: () -> Unit)
    fun setKeyYReleased(function: () -> Unit)
    fun setKeyZReleased(function: () -> Unit)

    fun setKey1Released(function: () -> Unit)
    fun setKey2Released(function: () -> Unit)
    fun setKey3Released(function: () -> Unit)
    fun setKey4Released(function: () -> Unit)
    fun setKey5Released(function: () -> Unit)
    fun setKey6Released(function: () -> Unit)
    fun setKey7Released(function: () -> Unit)
    fun setKey8Released(function: () -> Unit)
    fun setKey9Released(function: () -> Unit)
    fun setKey0Released(function: () -> Unit)

    fun setKeyEscReleased(function: () -> Unit)
    fun setKeyF1Released(function: () -> Unit)
    fun setKeyF2Released(function: () -> Unit)
    fun setKeyF3Released(function: () -> Unit)
    fun setKeyF4Released(function: () -> Unit)
    fun setKeyF5Released(function: () -> Unit)
    fun setKeyF6Released(function: () -> Unit)
    fun setKeyF7Released(function: () -> Unit)
    fun setKeyF8Released(function: () -> Unit)
    fun setKeyF9Released(function: () -> Unit)
    fun setKeyF10Released(function: () -> Unit)
    fun setKeyF11Released(function: () -> Unit)
    fun setKeyF12Released(function: () -> Unit)

    fun setKeyBackslashReleased(function: () -> Unit)
    fun setKeyApostropheReleased(function: () -> Unit)
    fun setKeyRightAltReleased(function: () -> Unit)
    fun setKeyLeftAltReleased(function: () -> Unit)
    fun setKeyGraveAccentReleased(function: () -> Unit)
    fun setKeyBackspaceReleased(function: () -> Unit)
    fun setKeyLeftBracketReleased(function: () -> Unit)
    fun setKeyRightBracketReleased(function: () -> Unit)
    fun setKeyCapsLockReleased(function: () -> Unit)
    fun setKeyCommaReleased(function: () -> Unit)
    fun setKeyLeftControlReleased(function: () -> Unit)
    fun setKeyRightControlReleased(function: () -> Unit)
    fun setKeyDeleteReleased(function: () -> Unit)
    fun setKeyEnterReleased(function: () -> Unit)
    fun setKeyEqualReleased(function: () -> Unit)
    fun setKeyInsertReleased(function: () -> Unit)
    fun setKeyLastReleased(function: () -> Unit)
    fun setKeyLeftShiftReleased(function: () -> Unit)
    fun setKeyRightShiftReleased(function: () -> Unit)
    fun setKeyLeftSuperReleased(function: () -> Unit)
    fun setKeyRightSuperReleased(function: () -> Unit)
    fun setKeyNumLockReleased(function: () -> Unit)
    fun setKeyScrollLockReleased(function: () -> Unit)
    fun setKeyMenuReleased(function: () -> Unit)
    fun setKeyMultiplyReleased(function: () -> Unit)
    fun setKeyMinusReleased(function: () -> Unit)
    fun setKeyPauseReleased(function: () -> Unit)
    fun setKeyPrintScreenReleased(function: () -> Unit)
    fun setKeyPeriodReleased(function: () -> Unit)
    fun setKeySemicolonReleased(function: () -> Unit)
    fun setKeySlashReleased(function: () -> Unit)
    fun setKeySpaceReleased(function: () -> Unit)
    fun setKeyTabReleased(function: () -> Unit)
    fun setKeyUnknownReleased(function: () -> Unit)

    fun setKeyNumeric1Released(function: () -> Unit)
    fun setKeyNumeric2Released(function: () -> Unit)
    fun setKeyNumeric3Released(function: () -> Unit)
    fun setKeyNumeric4Released(function: () -> Unit)
    fun setKeyNumeric5Released(function: () -> Unit)
    fun setKeyNumeric6Released(function: () -> Unit)
    fun setKeyNumeric7Released(function: () -> Unit)
    fun setKeyNumeric8Released(function: () -> Unit)
    fun setKeyNumeric9Released(function: () -> Unit)
    fun setKeyNumericAddReleased(function: () -> Unit)
    fun setKeyNumericSubtractReleased(function: () -> Unit)
    fun setKeyNumericMultiplyReleased(function: () -> Unit)
    fun setKeyNumericDivideReleased(function: () -> Unit)
    fun setKeyNumericEnterReleased(function: () -> Unit)
    fun setKeyNumericEqualReleased(function: () -> Unit)
    fun setKeyNumericDecimalReleased(function: () -> Unit)

    fun setKeyPageDownReleased(function: () -> Unit)
    fun setKeyPageUpReleased(function: () -> Unit)
    fun setKeyHomeReleased(function: () -> Unit)
    fun setKeyEndReleased(function: () -> Unit)

    fun setKeyUpReleased(function: () -> Unit)
    fun setKeyDownReleased(function: () -> Unit)
    fun setKeyLeftReleased(function: () -> Unit)
    fun setKeyRightReleased(function: () -> Unit)
}