package com.example.data.data.db.app_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.data.db.dao.ProductDao

import com.example.data.data.model.all_products.ProductEntity
import com.example.data.data.model.all_products.RatingEntity


@Database(entities = [ProductEntity::class,RatingEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao
}