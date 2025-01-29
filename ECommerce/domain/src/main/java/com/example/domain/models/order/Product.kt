package com.example.domain.models.order

import android.os.Parcelable
import com.example.domain.models.Category
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Product(

	val imageCover: String? = null,

	val id: String? = null,



	val subcategory: @RawValue List<SubcategoryItem?>? = null,

	val title: String? = null,

	val category: @RawValue Category? = null,

	val ratingsQuantity: Int? = null,

	val brand: @RawValue Brand? = null,

	val ratingsAverage: @RawValue Any? = null
):Parcelable