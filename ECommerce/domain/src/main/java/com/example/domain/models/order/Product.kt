package com.example.domain.models.order

import com.example.domain.models.Category


data class Product(

	val imageCover: String? = null,

	val id: String? = null,



	val subcategory: List<SubcategoryItem?>? = null,

	val title: String? = null,

	val category: Category? = null,

	val ratingsQuantity: Int? = null,

	val brand: Brand? = null,

	val ratingsAverage: Any? = null
)