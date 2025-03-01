package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Brand(

	val image: String? = null,

	val name: String? = null,

	val id: String? = null,

	val slug: String? = null
):Parcelable