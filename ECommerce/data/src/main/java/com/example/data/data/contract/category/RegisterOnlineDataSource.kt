package com.example.data.data.contract.category

import com.example.data.data.model.user.UserResponse
import com.example.domain.models.user.User

interface RegisterOnlineDataSource {
    suspend fun registerUser(user:User):UserResponse
    suspend fun loginUser(user:User):UserResponse
}