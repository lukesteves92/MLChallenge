package com.inspirecoding.mlchallenge.data.remote.services.responseapi

sealed class ResponseApi{
    class Success(var data: Any?) : ResponseApi()
    class ErrorException(var data: Any?) : ResponseApi()
}