package com.example.e_commerce.products.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.Resource
import com.example.domain.models.all_products.Product
import com.example.domain.models.order.Order
import com.example.domain.usecase.ProductsRepositoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productsRepositoryUseCase: ProductsRepositoryUseCase
):ViewModel() {

    val products = MutableLiveData<List<Product?>?>()

    val isLoading = MutableLiveData<Boolean>(false)
    val error = MutableLiveData<String>()

    fun getAllProducts(){
        viewModelScope.launch (Dispatchers.IO){
            productsRepositoryUseCase.getAllProducts()
                .collect{
                        resource->
                    when(resource)
                    {
                        is Resource.Success -> {
                            Log.e("success error","yes")
                            isLoading.postValue(false)
                            products.postValue(resource.data)
                        }
                        else -> {handleError(resource)}
                    }
                }
        }
    }



    fun getAllProductsForCategoryName(categoryName:String)
    {
        viewModelScope.launch(Dispatchers.IO) {
            productsRepositoryUseCase.getProductsByCategoryName(categoryName)
                .collect{resource->

                    when(resource)
                    {
                        is Resource.Success ->{

                            isLoading.postValue(false)
                            products.postValue(resource.data)
                        }
                        is Resource.Loading -> {
                            isLoading.postValue(true)
                        }
                        else -> handleError(resource)
                    }
                }
        }
    }
    private fun <T>handleError(resource: Resource<T>)
    {
        when(resource) {

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