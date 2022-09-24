package kgames.core.audio

import kgames.core.file.KFile
import kgames.core.file.KFolder
import org.lwjgl.openal.AL10.*
import org.lwjgl.stb.STBVorbis.stb_vorbis_decode_filename
import org.lwjgl.system.MemoryStack.*
import org.lwjgl.system.libc.LibCStdlib.free
import java.nio.ShortBuffer

class Sound(
    private val filePath: String,
    loops: Boolean
) {

    private val invalidValue = -1

    private var stackPushCounter = 0

    private val bufferId: Int
    private val sourceId: Int

    private var isPlaying = false

    init {
        addStackPush()
        val channelsBuffer = stackMallocInt(1)
        addStackPush()
        val sampleRateBuffer = stackMallocInt(1)

        val rawAudioBuffer = stb_vorbis_decode_filename(
            getPath(),
            channelsBuffer,
            sampleRateBuffer
        )

        if (checkRawAudioBuffer(rawAudioBuffer)) {
            val channels = channelsBuffer.get()
            val sampleRate = sampleRateBuffer.get()
            callStackPop()
            val format = getOpenALFormat(channels)

            bufferId = alGenBuffers()
            alBufferData(bufferId, format, rawAudioBuffer!!, sampleRate)

            sourceId = alGenSources()
            alSourcei(sourceId, AL_BUFFER, bufferId)
            alSourcei(sourceId, AL_LOOPING, if (loops) 1 else 0)
            alSourcei(sourceId, AL_POSITION, 0)
            alSourcef(sourceId, AL_GAIN, 0.3f)

            free(rawAudioBuffer)
        } else {
            bufferId = invalidValue
            sourceId = invalidValue
        }
    }

    private fun getPath(): String {
        val file = KFile(KFolder.getRootFolder(), filePath)
        return file.getFile().absolutePath
    }

    private fun checkRawAudioBuffer(rawAudioBuffer: ShortBuffer?): Boolean {
        return if (rawAudioBuffer == null) {
            System.err.println("Could not load sound '${getPath()}'")
            callStackPop()
            false
        } else true
    }

    private fun getOpenALFormat(channels: Int): Int {
        return when (channels) {
            1 -> AL_FORMAT_MONO16
            2 -> AL_FORMAT_STEREO16
            else -> invalidValue
        }
    }

    private fun addStackPush() {
        stackPush()
        stackPushCounter++
    }

    private fun callStackPop() {
        for (call in 0 until stackPushCounter) {
            stackPop()
        }
        stackPushCounter = 0
    }

    fun dispose() {
        if (sourceIdIsValid()) {
            alDeleteSources(sourceId)
            alDeleteBuffers(bufferId)
        }
    }

    fun play() {
        if (!isPlaying && sourceIdIsValid()) {
            if (getState() == AL_STOPPED) {
                isPlaying = false
                alSourcei(sourceId, AL_POSITION, 0)
            }
            playSource()
        }
    }

    private fun playSource() {
        if (!isPlaying) {
            alSourcePlay(sourceId)
            isPlaying = true
        }
    }

    fun pause() {
        stopSource { alSourcePause(sourceId) }
    }

    private fun stopSource(action: () -> Unit) {
        if (isPlaying && sourceIdIsValid()) {
            action()
            isPlaying = false
        }
    }

    fun resume() {
        if (!isPlaying && sourceIdIsValid()) {
            if (getState() == AL_PAUSED) {
                isPlaying = false
            }
            playSource()
        }
    }

    fun stop() {
        stopSource { alSourceStop(sourceId) }
    }

    fun isPlaying(): Boolean {
        if (sourceIdIsValid()) {
            isPlaying = getState() == AL_PLAYING
        }
        return isPlaying
    }

    private fun sourceIdIsValid() = sourceId != invalidValue

    private fun getState() = alGetSourcei(sourceId, AL_SOURCE_STATE)

}