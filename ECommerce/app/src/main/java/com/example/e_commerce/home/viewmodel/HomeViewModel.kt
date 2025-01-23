package com.example.e_commerce.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.contract.category.ProductsRepository
import com.example.domain.models.Category
import com.example.domain.models.all_products.Product
import com.example.domain.usecase.CategoriesRepositoryUseCase
import com.example.domain.usecase.ProductsRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoriesRepositoryUseCase: CategoriesRepositoryUseCase
): ViewModel() {
     val categories = MutableLiveData<List<Category?>?>()

     val isLoading = MutableLiveData<Boolean>(false)
     val error = MutableLiveData<String>()



    fun getAllCategories(){
        viewModelScope.launch (Dispatchers.IO){
            categoriesRepositoryUseCase.getAllCategories()

                .collect{
                        resource->
                    when(resource) {


                        is Resource.Success -> {
                            isLoading.postValue(false)
                            categories.postValue(resource.data)
                        }
                        else -> {handleError(resource)}


                    }
//                    categories.postValue(it)
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