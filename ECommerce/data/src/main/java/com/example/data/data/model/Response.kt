package com.example.data.data.model

import com.google.gson.annotations.SerializedName

data class Response<T>(

    @field:SerializedName("metadata")
	val metadata: Pagination? = null,

    @field:SerializedName("data")
	val data: T? = null,

    @field:SerializedName("results")
	val results: Int? = null,

    @field:SerializedName("statusMsg")
	val statusMsg: Int? = null,

    @field:SerializedName("message")
	val message: Int? = null

)