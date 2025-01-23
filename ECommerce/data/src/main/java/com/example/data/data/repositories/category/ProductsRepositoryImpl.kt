package com.example.data.data.repositories.category

import android.content.Context
import android.util.Log
import com.example.data.data.contract.category.ProductOfflineDataSource
import com.example.data.data.contract.category.ProductOnlineDataSource
import com.example.data.data.model.all_products.RatingEntity
import com.example.data.data.model.new_order.helper_extentions.toDataItem
import com.example.data.data.model.new_order.helper_extentions.toOrder
import com.example.data.data.network_handler.NetworkHandler
import com.example.domain.common.InternetExceptionError
import com.example.domain.common.Resource
import com.example.domain.contract.category.ProductsRepository
import com.example.domain.models.all_products.Product
import com.example.domain.models.all_products.Rating
import com.example.domain.models.order.Order
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import utils.hasNetworkConnection
import utils.safeApiCall

class ProductsRepositoryImpl(
    private val productOnlineDataSource: ProductOnlineDataSource,
    private val productOfflineDataSource: ProductOfflineDataSource,
    private val networkHandler:NetworkHandler
): ProductsRepository {
    override suspend fun getAllProducts(): Flow<Resource<List<Product?>?>> {

        if (networkHandler.isNetworkAvailable()) {
            Log.e("has internet", "yes")
            return safeApiCall {
                val productsEntity = productOnlineDataSource.getAllProducts()
                productOfflineDataSource.deleteProducts()
                productOfflineDataSource.deleteRatings()
                productOfflineDataSource.saveProducts(productsEntity)

                productsEntity.map {

                    productOfflineDataSource.saveRatings(it?.ratingEntity)
                }

                productsEntity.map {
                    it?.toProduct()
                }

            }
        } else {
            return safeApiCall {
               getOfflineData()
            }
        }

    }

    override suspend fun getProductsByCategoryName(categoryName: String): Flow<Resource<List<Product?>?>> {


        if (networkHandler.isNetworkAvailable()) {
            return safeApiCall {
                productOnlineDataSource.getProductsByCategoryName(categoryName).map {
                    it?.toProduct()
                }
            }
        }


        else {
            return safeApiCall {
                getOfflineData()?.filter {
                    it?.category == categoryName
                }

            }
        }


    }

    private suspend fun getOfflineData():List<Product?>?{

        val ratings: List<Rating>? =
            productOfflineDataSource.getAllRatings()?.filterNotNull()?.map {
                it.toRating()

            }

       return productOfflineDataSource.getAllProducts()?.map {

            var product: Product? = it?.toProduct()

            if (ratings != null) {
                for (rate in ratings)
                    if (product?.productId == rate.ratingId) {
                        product = product?.copy(rating = rate)
                    }
            }
            product
        }
    }

    override suspend fun getAllOrders(): Flow<Resource<Order?>> {
        return safeApiCall {
            Log.e("order safe","yes")
            productOnlineDataSource.getAllOrders().toOrder()
//                .map {
//                Log.e("orders","${it?.toOrder()}")
//                it?.toOrder()
//            }

        }
//        return safeApiCall {
//            listOf()
//        }
        }
    }




