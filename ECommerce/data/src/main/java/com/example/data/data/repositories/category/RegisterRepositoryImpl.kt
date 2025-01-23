package com.example.data.data.repositories.category

import com.example.data.data.contract.category.RegisterOnlineDataSource
import com.example.domain.common.Resource
import com.example.domain.contract.category.RegisterRepository
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow
import utils.safeApiCall
import javax.inject.Inject

class RegisterRepositoryImpl (
    private val registerOnlineDataSource:RegisterOnlineDataSource
)
:RegisterRepository {
    override suspend fun registerUser(user: User): Flow<Resource<User>> {

       return safeApiCall {
            registerOnlineDataSource.registerUser(user).toUser()
        }
    }

    override suspend fun loginUser(user: User): Flow<Resource<User>> {
        return safeApiCall {
            registerOnlineDataSource.loginUser(user).toUser()
        }
    }
}