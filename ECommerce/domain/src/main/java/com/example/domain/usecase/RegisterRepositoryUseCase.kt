package com.example.domain.usecase

import com.example.domain.common.Resource
import com.example.domain.contract.category.RegisterRepository
import com.example.domain.models.user.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterRepositoryUseCase @Inject constructor(
    private val registerRepository:RegisterRepository
) {

    suspend fun registerUser(user: User): Flow<Resource<User>>
    {
      return  registerRepository.registerUser(user)
    }
    suspend fun loginUser(user:User):Flow<Resource<User>>
    {
       return registerRepository.loginUser(user)
    }
}