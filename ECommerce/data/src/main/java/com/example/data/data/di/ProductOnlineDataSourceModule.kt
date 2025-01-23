package com.example.data.data.di

import com.example.data.data.api.WebService
import com.example.data.data.contract.category.ProductOnlineDataSource
import com.example.data.data.datasource.category.ProductOnlineDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object ProductOnlineDataSourceModule {
    @Provides
    fun provideProductOnlineDataSource(webService: WebService): ProductOnlineDataSource {
        return ProductOnlineDataSourceImpl(webService)
    }
}