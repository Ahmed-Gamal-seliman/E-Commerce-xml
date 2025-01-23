package com.example.data.data.di

import com.example.data.data.api.WebService
import com.example.data.data.contract.category.CategoryOnlineDataSource
import com.example.data.data.datasource.category.CategoriesOnlineDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object CategoryOnlineDataSourceModule {

    @Provides
    fun provideCategoryOnlineDataSource(webService: WebService):CategoryOnlineDataSource{
        return CategoriesOnlineDataSourceImpl(webService)
    }

}
