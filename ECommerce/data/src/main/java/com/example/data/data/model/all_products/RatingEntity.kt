package com.example.data.data.model.all_products

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.domain.models.all_products.Rating
import com.google.gson.annotations.SerializedName

@Entity(foreignKeys = [ForeignKey(ProductEntity::class, parentColumns = ["productId"], childColumns = ["id"], onDelete = ForeignKey.CASCADE)])
data class RatingEntity(

	@PrimaryKey(autoGenerate = true)
	val id:Int=0,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("count")
	val count: Int? = null
){
	fun toRating():Rating{
		return Rating(
			rate = rate,
			count=count,
			ratingId = id
		)
	}
}