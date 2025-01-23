package com.example.data.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.all_products.RatingEntity
import com.example.domain.models.all_products.Rating


@Dao
interface ProductDao {

    @Query("SELECT * from ProductEntity")
    suspend fun getAllProducts():List<ProductEntity?>?

    @Query("SELECT * from RatingEntity")
    suspend fun getAllRatings():List<RatingEntity?>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(product: List<ProductEntity?>)

    @Query("DELETE FROM ProductEntity")
    suspend fun deleteProducts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRatings(rating:RatingEntity?)

    @Query("DELETE FROM RatingEntity")
    suspend fun deleteRatings()
}