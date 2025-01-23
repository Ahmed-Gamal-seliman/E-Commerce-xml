package com.example.data.data.datasource.category

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.ContextCompat
import androidx.core.content.SharedPreferencesCompat
import com.example.data.data.api.WebService
import com.example.data.data.contract.category.RegisterOnlineDataSource
import com.example.data.data.model.user.UserResponse
import com.example.domain.models.user.User

class RegisterOnlineDataSourceImpl(
    private val webService:WebService
):RegisterOnlineDataSource {
    override suspend fun registerUser(user: User): UserResponse {
        return webService.registerUser("https://ecommerce.routemisr.com/api/v1/auth/signup",user)
    }

    override suspend fun loginUser(user: User): UserResponse {

        return webService.loginUser("https://ecommerce.routemisr.com/api/v1/auth/signin",user)

    }
}