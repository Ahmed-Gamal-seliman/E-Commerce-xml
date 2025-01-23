package com.example.domain.common

data class ServerError(
    val statusMessage:String?=null,
     val serverError:String?=null
): Exception(){}
