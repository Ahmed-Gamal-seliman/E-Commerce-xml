package com.example.data.data.datasource.category

import android.util.Log
import com.example.data.data.CategoryState
import com.example.data.data.api.WebService
import com.example.data.data.contract.category.CategoryOnlineDataSource
import com.example.data.data.model.CategoryDto
import com.example.data.data.model.Response
import com.example.domain.common.Resource
import com.example.domain.models.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.toList
import utils.executeApi
import javax.inject.Inject

class CategoriesOnlineDataSourceImpl @Inject constructor(
    private val webService:WebService
): CategoryOnlineDataSource {
    override suspend fun getAllCategories(): List<Category?>? {
        Log.e("enter", "yes")


            return  executeApi {
                webService.getCategories().data?.map {
                    it?.toCategory()
                }
            }



    }
}