package com.inspirecoding.mlchallenge.data.remote.services.responseapi

import com.inspirecoding.mlchallenge.data.utils.exception.MLChallengeException

sealed class ResponseApi<out T> {
    class Success<T>(var data: T?) : ResponseApi<T>()
    class ErrorException(var errorException: MLChallengeException) : ResponseApi<Nothing>()
}