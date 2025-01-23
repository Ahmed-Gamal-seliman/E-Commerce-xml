package com.example.e_commerce.products.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.Visibility
import com.example.domain.models.all_products.Product
import com.example.domain.models.order.Order
import com.example.e_commerce.DestinationType
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentProductsBinding
import com.example.e_commerce.home.viewmodel.HomeViewModel
import com.example.e_commerce.products.ui.adapter.ProductAdapter
import com.example.e_commerce.products.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    lateinit var binding: FragmentProductsBinding
    val viewModel: ProductViewModel by viewModels<ProductViewModel>()
    lateinit var productAdapter: ProductAdapter
    val args: ProductsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.e("product fragment","create view")
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("product fragment","view created")
        super.onViewCreated(view, savedInstanceState)
        initProductRecyclerView()
        onTryAgainButtonClicked()

        observeLiveData()

        callProductApi()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("product fragment","on destroy view")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e("product fragment","destroyed")
    }
    private fun callProductApi() {
        if (args.categoryName != null) {

            viewModel.getAllProductsForCategoryName(args.categoryName!!)
        }
        else {
            viewModel.getAllProducts()
        }

    }

    private fun onTryAgainButtonClicked() {
        binding.btnTryAgain.setOnClickListener {
            showShimmer()
            clearError()
           callProductApi()
        }
    }

    private fun initProductRecyclerView() {
        productAdapter = ProductAdapter(mutableListOf())
        binding.rvProductItem.adapter= productAdapter
        productAdapter.onProductClicked = ProductAdapter.onProductClickListener {
            product->
            Log.e("product","${product.price}")
            val action= ProductsFragmentDirections.actionProductsFragmentToProductDetailsFragment(product)
            findNavController().navigate(action)
        }


    }

    private fun observeLiveData() {
        viewModel.products.observe(viewLifecycleOwner)
        { products ->
            showProducts(products)

        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            Log.e("isLoading", "${isLoading}")
                showShimmer()
        }
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Log.e("error", "${errorMessage}")
            clearShimmer()
            showError(errorMessage)

        }



    }



    private fun showError(errorMessage: String) {
        binding.tvErrorMessage.text = errorMessage
        binding.tvErrorMessage.isVisible= true
        binding.btnTryAgain.isVisible= true
    }

    private fun clearError(){
        binding.tvErrorMessage.isVisible= false
        binding.btnTryAgain.isVisible= false
    }

    private fun showShimmer() {
        binding.shimmerItem.startShimmer()
        binding.shimmerItem.isVisible= true
    }

    private fun clearShimmer(){
        binding.shimmerItem.stopShimmer()
        binding.shimmerItem.isVisible= false
    }
    private fun showProducts(products: List<Product?>?) {
        clearShimmer()
        binding.rvProductItem.isVisible= true
        productAdapter.setData(products)


    }
}

