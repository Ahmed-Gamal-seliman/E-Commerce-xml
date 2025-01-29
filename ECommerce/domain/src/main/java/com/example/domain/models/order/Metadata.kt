package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Metadata(

	val numberOfPages: Int? = null,

	val nextPage: Int? = null,

	val limit: Int? = null,

	val currentPage: Int? = null
):Parcelable