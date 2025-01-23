package com.example.data.data.repositories.category

import com.example.data.data.contract.category.CategoryOnlineDataSource
import com.example.domain.common.Resource
import com.example.domain.contract.category.CategoriesRepository
import com.example.domain.models.Category
import kotlinx.coroutines.flow.Flow

import utils.safeApiCall
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val categoryOnlineDataSource: CategoryOnlineDataSource
): CategoriesRepository {

    override suspend fun getAllCategories(): Flow<Resource<List<Category?>?>> {
        return safeApiCall {
            categoryOnlineDataSource.getAllCategories()
        }

    }


}