package com.example.data.data.datasource.category

import android.util.Log
import com.example.data.data.api.WebService
import com.example.data.data.contract.category.ProductOnlineDataSource
import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.new_order.OrderEntity

import com.example.domain.common.Resource
import com.example.domain.models.all_products.Product
import com.example.domain.models.order.Order
import kotlinx.coroutines.flow.Flow
import utils.executeApi
import javax.inject.Inject

class ProductOnlineDataSourceImpl @Inject constructor(
    private val webService: WebService
) : ProductOnlineDataSource {
    override suspend fun getAllProducts(): List<ProductEntity?> {
        return executeApi {
            webService.getAllProducts()
        }
    }

    override suspend fun getProductsByCategoryName(categoryName: String): List<ProductEntity?> {
        return executeApi {
            webService.getProductsByCategoryName(categoryName)
        }
    }

    override suspend fun getAllOrders(): OrderEntity {
        return executeApi {
            Log.e("order webservice","execute")
            webService.getAllOrders("https://ecommerce.routemisr.com/api/v1/orders")
        }
    }
}