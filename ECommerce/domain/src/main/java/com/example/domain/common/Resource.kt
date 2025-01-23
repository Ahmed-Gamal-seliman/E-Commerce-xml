package com.example.domain.common

import java.net.SocketTimeoutException

sealed class Resource<out T> {

    data class Success<T>(val data:T):Resource<T>()
    data class Fail(val error:Throwable):Resource<Nothing>()
    data class ServerFail(val serverError:ServerError):Resource<Nothing>()
    data object Loading:Resource<Nothing>()
    data class TimeOutException(val error: SocketTimeoutException):Resource<Nothing>()
}