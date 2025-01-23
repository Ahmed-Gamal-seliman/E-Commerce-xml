package com.example.data.data.repositories.category

import com.example.data.data.contract.category.CategoryOnlineDataSource
import com.example.domain.contract.category.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object CategoriesRepositoryModule {

    @Provides
    fun provideCategoriesRepositoryImpl(categoryOnlineDataSource: CategoryOnlineDataSource):CategoriesRepository{
        return CategoriesRepositoryImpl(categoryOnlineDataSource)
    }


}