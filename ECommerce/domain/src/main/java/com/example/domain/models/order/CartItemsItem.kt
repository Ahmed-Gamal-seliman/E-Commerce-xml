package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class CartItemsItem(

	val product: @RawValue Product? = null,

	val price: Int? = null,

	val count: Int? = null,

	val id: String? = null
):Parcelable