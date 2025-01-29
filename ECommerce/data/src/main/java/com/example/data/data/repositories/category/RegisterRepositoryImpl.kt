package com.example.data.data.repositories.category

import com.example.data.data.contract.category.RegisterOnlineDataSource
import com.example.domain.common.Resource
import com.example.domain.contract.category.RegisterRepository
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow
import utils.safeApiCall

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
//        if(isValidInput(user)) {
            return safeApiCall {
                registerOnlineDataSource.loginUser(user).toUser()
            }
//        }
    }

    override fun isValidInput(user: User): Boolean {
        if(validateEmail(user.email) != null){
            return false
        }
        return true
    }

    private fun validateEmail(email:String?):String?
    {
        if(email?.isEmpty() == true)
        {
            return "required field"
        }
        return null
    }
}