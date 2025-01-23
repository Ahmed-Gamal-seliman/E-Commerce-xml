package com.example.data.data.model.new_order

import com.google.gson.annotations.SerializedName

data class OrderEntity(

	@field:SerializedName("metadata")
	val metadataEntity: MetadataEntity? = null,

	@field:SerializedName("data")
	val data: List<DataItemEntity?>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)

data class ProductEntity(

	@field:SerializedName("imageCover")
	val imageCover: String? = null,



	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("subcategory")
	val subcategory: List<SubcategoryItem?>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("category")
	val categoryEntity: CategoryEntity? = null,

	@field:SerializedName("ratingsQuantity")
	val ratingsQuantity: Int? = null,

	@field:SerializedName("brand")
	val brand: Brand? = null,

	@field:SerializedName("ratingsAverage")
	val ratingsAverage: Any? = null
)

data class User(

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class CartItemsItemEntity(

	@field:SerializedName("product")
	val productEntity: ProductEntity? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null
)

data class Brand(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class CategoryEntity(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class MetadataEntity(

	@field:SerializedName("numberOfPages")
	val numberOfPages: Int? = null,

	@field:SerializedName("nextPage")
	val nextPage: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("currentPage")
	val currentPage: Int? = null
)

data class SubcategoryItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null
)

data class DataItemEntity(

	@field:SerializedName("totalOrderPrice")
	val totalOrderPrice: Int? = null,

	@field:SerializedName("isPaid")
	val isPaid: Boolean? = null,

	@field:SerializedName("isDelivered")
	val isDelivered: Boolean? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("shippingPrice")
	val shippingPrice: Int? = null,

	@field:SerializedName("shippingAddress")
	val shippingAddress: ShippingAddress? = null,

	@field:SerializedName("taxPrice")
	val taxPrice: Int? = null,

	@field:SerializedName("_id")
	val Id: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("cartItems")
	val cartItems: List<CartItemsItemEntity?>? = null,

	@field:SerializedName("paymentMethodType")
	val paymentMethodType: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("paidAt")
	val paidAt: String? = null
)

data class ShippingAddress(

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("details")
	val details: String? = null
)
