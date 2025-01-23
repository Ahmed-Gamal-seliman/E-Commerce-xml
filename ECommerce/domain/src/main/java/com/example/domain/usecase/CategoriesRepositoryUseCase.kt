package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.contract.category.CategoriesRepository
import com.example.domain.models.Category
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CategoriesRepositoryUseCase @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) {

    suspend fun getAllCategories(): Flow<Resource<List<Category?>?>> {
       return categoriesRepository.getAllCategories()
    }
}