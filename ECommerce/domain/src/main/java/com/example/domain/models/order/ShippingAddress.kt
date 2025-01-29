package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShippingAddress(

	val phone: String? = null,

	val city: String? = null,

	val details: String? = null
):Parcelable