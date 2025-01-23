package com.example.data.data.contract.category

import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.new_order.OrderEntity



interface ProductOnlineDataSource {

     suspend fun getAllProducts(): List<ProductEntity?>

     suspend fun getProductsByCategoryName(categoryName:String):List<ProductEntity?>

     suspend fun getAllOrders():OrderEntity
}