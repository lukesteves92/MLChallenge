package com.inspirecoding.mlchallenge.data.remote.services.wrapper

import com.inspirecoding.mlchallenge.data.remote.services.responseapi.ResponseApi
import com.inspirecoding.mlchallenge.data.utils.exception.MLChallengeException
import com.inspirecoding.mlchallenge.extensions.string.containsTagHtml
import com.inspirecoding.mlchallenge.extensions.string.toDefaultError
import com.inspirecoding.mlchallenge.utils.Constants.Text.EMPTY_STRING_DEFAULT
import retrofit2.Response
import java.io.IOException
import javax.net.ssl.HttpsURLConnection

class RequestWrapperImpl: RequestWrapper {

    override suspend fun <T : Any> wrapper(call: suspend () -> Response<T>): ResponseApi {
        return try {
            val response = call.invoke()
            val errorBody = response.errorBody()?.string() ?: EMPTY_STRING_DEFAULT

            when {
                response.isSuccessful -> {

                    ResponseApi.Success(
                        data = response.body()
                    )
                }

                response.code() == HttpsURLConnection.HTTP_FORBIDDEN && errorBody.containsTagHtml() -> {
                    ResponseApi.ErrorException(
                        MLChallengeException.DefaultError(
                            errorBody,
                            "${response.code()}"
                        )
                    )
                }

                else -> {
                    val error = errorBody.toDefaultError()
                    ResponseApi.ErrorException(
                        MLChallengeException.DefaultError(
                            message = error?.message ?: EMPTY_STRING_DEFAULT,
                            code = error?.code ?: EMPTY_STRING_DEFAULT
                        )
                    )
                }
            }
        } catch (exception: IOException) {
            ResponseApi.ErrorException(MLChallengeException.ErrorNetworkException)
        } catch (exception: MLChallengeException) {
            ResponseApi.ErrorException(exception)
        }
    }
}