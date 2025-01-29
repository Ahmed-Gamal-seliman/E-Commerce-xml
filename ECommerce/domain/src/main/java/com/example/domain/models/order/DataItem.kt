package com.example.domain.models.order

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class DataItem(


	val totalOrderPrice: Int? = null,


	val isPaid: Boolean? = null,


	val isDelivered: Boolean? = null,


	val createdAt: String? = null,


	val shippingPrice: Int? = null,


	val shippingAddress:  @RawValue ShippingAddress? = null,


	val taxPrice: Int? = null,





	val id: Int? = null,

	val cartItems: List<CartItemsItem?>? = null,

	val paymentMethodType: String? = null,

	val user: @RawValue User? = null,

	val updatedAt: String? = null,

	val paidAt: String? = null
):Parcelable