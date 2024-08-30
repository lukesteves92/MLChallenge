package com.inspirecoding.mlchallenge.data.utils.singleorthrow

import com.inspirecoding.mlchallenge.data.utils.exception.MLChallengeException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single

suspend inline fun <T> Flow<T>.singleOrThrow(
    success: ((T) -> Unit),
    error: ((MLChallengeException) -> Unit)
) {
    try {
        success.invoke(single())
    } catch (e: MLChallengeException) {
        error.invoke(e)
    }
}