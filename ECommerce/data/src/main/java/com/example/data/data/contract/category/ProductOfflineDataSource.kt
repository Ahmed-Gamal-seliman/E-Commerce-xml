package com.example.data.data.contract.category

import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.all_products.RatingEntity
import com.example.domain.models.all_products.Product
import com.example.domain.models.all_products.Rating

interface ProductOfflineDataSource {

    suspend fun getAllProducts():List<ProductEntity?>?
    suspend fun getAllRatings():List<RatingEntity?>?

    suspend fun saveProducts(products:List<ProductEntity?>)
    suspend fun saveRatings(rating:RatingEntity?)
    suspend fun deleteRatings()
    suspend fun deleteProducts()
}