package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(

	val phone: String? = null,

	val name: String? = null,

	val id: String? = null,

	val email: String? = null
):Parcelable