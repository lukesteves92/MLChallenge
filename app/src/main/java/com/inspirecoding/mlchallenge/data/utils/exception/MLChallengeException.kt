package com.inspirecoding.mlchallenge.data.utils.exception

import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT

sealed class MLChallengeException(
    override val message: String? = EMPTY_STRING_DEFAULT,
    val code: String? = EMPTY_STRING_DEFAULT
) : Throwable() {
    data object ErrorNetworkException : MLChallengeException()
    class DefaultError(message: String, code: String) : MLChallengeException(message, code)
}