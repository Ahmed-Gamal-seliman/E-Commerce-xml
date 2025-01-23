package com.example.data.data.di

import com.example.data.data.api.WebService
import com.example.data.data.contract.category.RegisterOnlineDataSource
import com.example.data.data.datasource.category.RegisterOnlineDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterOnlineDataSourceModule {

    @Provides
    @Singleton
    fun provideRegisterOnlineDataSource(webService: WebService):RegisterOnlineDataSource{
        return RegisterOnlineDataSourceImpl(webService)
    }
}