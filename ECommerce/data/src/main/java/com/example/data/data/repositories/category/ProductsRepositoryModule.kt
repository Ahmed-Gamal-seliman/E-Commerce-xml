package com.example.data.data.repositories.category

import android.app.Application
import android.content.Context
import com.example.data.data.contract.category.ProductOfflineDataSource
import com.example.data.data.contract.category.ProductOnlineDataSource
import com.example.data.data.network_handler.NetworkHandler


import com.example.domain.contract.category.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProductOnlineDataSourceQualifer()

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProductOfflineDataSourceQualifier()

@Module
@InstallIn(SingletonComponent::class)
object ProductsRepositoryModule {

    @Provides
    @Singleton
    fun provideNetworkHandler(@ApplicationContext context: Context): NetworkHandler {

        return NetworkHandler(context)

    }

    @Provides
    fun provideProductsRepository(productOnlineDataSource: ProductOnlineDataSource,
                                  productOfflineDataSource: ProductOfflineDataSource,
                                  networkHandler: NetworkHandler):ProductsRepository{
        return ProductsRepositoryImpl(productOnlineDataSource= productOnlineDataSource,
            productOfflineDataSource= productOfflineDataSource,
            networkHandler= networkHandler
            )
    }


}