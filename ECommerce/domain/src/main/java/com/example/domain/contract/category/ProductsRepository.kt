package com.example.domain.contract.category

import com.example.domain.common.Resource
import com.example.domain.models.all_products.Product
import com.example.domain.models.order.Order
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getAllProducts(): Flow<Resource<List<Product?>?>>

    suspend fun getProductsByCategoryName(categoryName:String): Flow<Resource<List<Product?>?>>

    suspend fun getAllOrders(): Flow<Resource<Order?>>
}