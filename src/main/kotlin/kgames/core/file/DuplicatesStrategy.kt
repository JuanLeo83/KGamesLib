package kgames.core.file

/**
 * EXCLUDE - do not duplicate and return a Boolean with false
 * FAIL - throw a DuplicatedFileException
 * INCLUDE - create a duplicated file name with timestamp variant before extension
 * REPLACE - remove the old file before save the new file
 */
enum class DuplicatesStrategy {
    EXCLUDE,
    FAIL,
    INCLUDE,
    REPLACE
}