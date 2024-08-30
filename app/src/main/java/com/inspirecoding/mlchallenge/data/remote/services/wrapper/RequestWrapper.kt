package com.inspirecoding.mlchallenge.data.remote.services.wrapper

import com.inspirecoding.mlchallenge.data.remote.services.responseapi.ResponseApi
import retrofit2.Response

interface RequestWrapper {
    suspend fun <T : Any> wrapper(call: suspend () -> Response<T>): ResponseApi
}