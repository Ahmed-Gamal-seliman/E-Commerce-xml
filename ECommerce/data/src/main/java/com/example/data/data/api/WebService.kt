package com.example.data.data.api

import com.example.data.data.model.CategoryDto
import com.example.data.data.model.Response
import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.new_order.OrderEntity
import com.example.data.data.model.user.UserResponse
import com.example.domain.models.user.User

import retrofit2.http.Body

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Url


interface WebService {
    @GET("/products/categories")
    suspend fun getCategories(): Response<List<CategoryDto?>?>

    @GET("/products")
    suspend fun getAllProducts(): List<ProductEntity>

    @GET("/products/category/{categoryName}")
    suspend fun getCategory(@Path("categoryName") categoryName:String)

    @GET("/products/category/{categoryName}")
    suspend fun getProductsByCategoryName(@Path("categoryName") categoryName:String):List<ProductEntity>

    @GET
    suspend fun getAllOrders(@Url url:String): OrderEntity

    @POST
    suspend fun registerUser(@Url url:String,@Body user: User):UserResponse

    @POST
    suspend fun loginUser(@Url url:String,@Body user:User):UserResponse
}