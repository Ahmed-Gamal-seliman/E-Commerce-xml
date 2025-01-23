package com.example.data.data.datasource.category

import com.example.data.data.contract.category.ProductOfflineDataSource
import com.example.data.data.db.app_db.AppDatabase
import com.example.data.data.db.dao.ProductDao
import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.all_products.RatingEntity
import com.example.domain.models.all_products.Product
import com.example.domain.models.all_products.Rating
import javax.inject.Inject

class ProductOfflineDataSourceImpl @Inject constructor(
    private val productDao: ProductDao
): ProductOfflineDataSource {
    override suspend fun getAllProducts(): List<ProductEntity?>? {
        return productDao.getAllProducts()
    }

    override suspend fun getAllRatings(): List<RatingEntity?>? {
        return productDao.getAllRatings()
    }

    override suspend fun saveProducts(products:List<ProductEntity?>) {
        productDao.saveProducts(products)
    }

    override suspend fun saveRatings(rating:RatingEntity?) {
        productDao.saveRatings(rating)
    }

    override suspend fun deleteRatings() {
        productDao.deleteRatings()
    }

    override suspend fun deleteProducts() {
        productDao.deleteProducts()
    }
}