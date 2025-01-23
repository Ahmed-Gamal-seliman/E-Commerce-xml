package com.example.e_commerce.authentication.signup.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.models.Category
import com.example.domain.models.user.User
import com.example.domain.usecase.RegisterRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SingupViewModel @Inject constructor(
    private val registerUseCase:RegisterRepositoryUseCase
):ViewModel() {
    val userLive= MutableLiveData<User?>()

    val isLoading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String>()

    fun registerUser(user:User){
        viewModelScope.launch(Dispatchers.IO) {
            registerUseCase.registerUser(user)
                .collect{resource->

                    when(resource)
                    {
                        is Resource.Success -> {
                            isLoading.postValue(false)
                            userLive.postValue(resource.data)
                        }
                        else -> {handleError(resource)}
                        }
                }
        }
    }
    private fun <T>handleError(resource: Resource<T>)
    {
        when(resource) {
            is Resource.Loading -> {
                Log.e("loading","yes")
                isLoading.postValue(true)
            }
            is Resource.ServerFail -> {
                isLoading.postValue(false)
                Log.e("servererror", "yes")

//            isLoading.postValue(false)
                error.postValue(resource.serverError.statusMessage ?: "server fail")
            }

            is Resource.Fail -> {
                isLoading.postValue(false)
                Log.e("error", "yes")
//            isLoading.postValue(false)
                error.postValue(resource.error.message)
            }
            else -> {
                Log.e("else error","yes")}
        }
    }
}