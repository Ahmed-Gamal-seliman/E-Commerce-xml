package com.example.data.data.model.all_products

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.domain.models.all_products.Product
import com.google.gson.annotations.SerializedName

@Entity()
data class ProductEntity(

	@PrimaryKey(autoGenerate = true)
	val productId:Int,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,




	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("category")
	val category: String? = null,




){
	@Ignore
	@field:SerializedName("rating")
	val ratingEntity: RatingEntity? = null

	fun toProduct():Product{
		return Product(
			title = title,
			image = image,
			price = price,
			rating = ratingEntity?.toRating(),
			category = category,
			description = description,
			productId = productId
		)
	}
}