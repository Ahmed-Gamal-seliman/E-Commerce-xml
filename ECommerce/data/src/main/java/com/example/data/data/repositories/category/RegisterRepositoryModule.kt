package com.example.data.data.repositories.category

import com.example.data.data.contract.category.RegisterOnlineDataSource
import com.example.domain.contract.category.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterRepositoryModule {

    @Provides
    @Singleton
    fun provideRegisterRepository(registerOnlineDataSource:RegisterOnlineDataSource):RegisterRepository{
        return RegisterRepositoryImpl(registerOnlineDataSource)
    }
}