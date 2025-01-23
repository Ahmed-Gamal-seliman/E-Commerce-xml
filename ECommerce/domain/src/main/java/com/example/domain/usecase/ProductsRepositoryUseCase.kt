package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.contract.category.ProductsRepository
import com.example.domain.models.Category
import com.example.domain.models.all_products.Product
import com.example.domain.models.order.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun getAllProducts(): Flow<Resource<List<Product?>?>> {
        return productsRepository.getAllProducts()
    }

    suspend fun getProductsByCategoryName(categoryName:String):Flow<Resource<List<Product?>?>>
    {
        return productsRepository.getProductsByCategoryName(categoryName)
    }

    suspend fun getAllOrders():Flow<Resource<Order?>>
    {
        return productsRepository.getAllOrders()
    }
}