package kgames.core.audio

import org.lwjgl.openal.AL
import org.lwjgl.openal.ALC
import org.lwjgl.openal.ALC10.*
import org.lwjgl.openal.ALCCapabilities
import org.lwjgl.openal.ALCapabilities

class AudioManager {

    private var defaultDeviceName: String? = null
    private var audioDevice: Long = 0

    private lateinit var attributes: IntArray
    private var audioContext: Long = 0

    private lateinit var alcCapabilities: ALCCapabilities
    private lateinit var alCapabilities: ALCapabilities

    fun init() {
        defaultDeviceName = alcGetString(0, ALC_DEFAULT_DEVICE_SPECIFIER)
        audioDevice = alcOpenDevice(defaultDeviceName)

        attributes = IntArray(1) { 0 }
        audioContext = alcCreateContext(audioDevice, attributes)
        alcMakeContextCurrent(audioContext)

        alcCapabilities = ALC.createCapabilities(audioDevice)
        alCapabilities = AL.createCapabilities(alcCapabilities)

        check(alCapabilities.OpenAL10) { "Audio library not supported" }
    }

    fun dispose() {
        alcDestroyContext(audioContext)
        alcCloseDevice(audioDevice)
    }
}