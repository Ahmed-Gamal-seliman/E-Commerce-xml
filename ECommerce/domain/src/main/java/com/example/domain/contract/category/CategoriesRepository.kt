package com.example.domain.contract.category

import com.example.domain.common.Resource
import com.example.domain.models.Category
import com.example.domain.models.all_products.Product
import kotlinx.coroutines.flow.Flow

interface CategoriesRepository {

    suspend fun getAllCategories(): Flow<Resource<List<Category?>?>>


}