package com.example.data.data.model

import com.example.domain.models.Category
import com.google.gson.annotations.SerializedName

data class CategoryDto(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)
{
	fun toCategory():Category{
		return Category(
			id = id,
			name = name,
			slug = slug,
			image = image
		)
	}
}