package com.example.data.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.data.contract.category.ProductOfflineDataSource
import com.example.data.data.datasource.category.ProductOfflineDataSourceImpl
import com.example.data.data.db.app_db.AppDatabase
import com.example.data.data.db.dao.ProductDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductOfflineDataSourceModule {

    @Provides
    @Singleton
    fun ProvideRoomDatabase(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(
            context = context,
            name = "product_db",
            klass = AppDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(productDatabase:AppDatabase): ProductDao{
        return productDatabase.productDao()
    }

    @Provides
    fun provideProductOfflineDataSource(productDao: ProductDao):ProductOfflineDataSource{
        return ProductOfflineDataSourceImpl(productDao)
    }
}