package com.example.domain.contract.category

import com.example.domain.common.Resource
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
    suspend fun registerUser(user: User): Flow<Resource<User>>

    suspend fun loginUser(user:User):Flow<Resource<User>>
}