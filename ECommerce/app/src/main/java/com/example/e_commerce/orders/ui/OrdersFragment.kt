package com.example.e_commerce.orders.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.models.order.CartItemsItem
import com.example.domain.models.order.Order
import com.example.e_commerce.DestinationType
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentOrdersBinding
import com.example.e_commerce.orders.ui.order_adapter.OrdersAdapter
import com.example.e_commerce.orders.viewmodel.OrdersViewModel
import com.example.e_commerce.products.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : Fragment() {

     lateinit var binding:FragmentOrdersBinding
     lateinit var ordersAdapter: OrdersAdapter

    val viewModel: OrdersViewModel by viewModels<OrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding= FragmentOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOrderRecyclerView()

        observeLiveData()
        viewModel.getAllOrders()

    }

    private fun initOrderRecyclerView() {
        ordersAdapter = OrdersAdapter(emptyList())
        ordersAdapter.onOrderClicked= OrdersAdapter.OnOrderClickListener {
            order->
            val action= OrdersFragmentDirections.actionOrdersFragmentToOrderDetailsFragment(order)
            findNavController().navigate(action)
        }
        binding.rvOrders.adapter= ordersAdapter

    }

    private fun observeLiveData() {
        viewModel.orders.observe(viewLifecycleOwner){
                order->
            clearShimmer()
            val cartItemList = mutableListOf<CartItemsItem>()
          for(data in order?.data!!)
          {
              for(cartItem in data?.cartItems!!) {
                  cartItemList.add(cartItem!!)
              }
          }

            showOrders(cartItemList)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            Log.e("isLoading", "${isLoading}")
            showShimmer()
            binding.rvOrders.isVisible= false
        }
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Log.e("error", "${errorMessage}")
            clearShimmer()
//            showError(errorMessage)

        }
    }

    private fun showOrders(cartItemsList: List<CartItemsItem>) {
        binding.rvOrders.isVisible= true
        ordersAdapter.setData(cartItemsList)
    }

    private fun showShimmer() {
        binding.orderShimmer.startShimmer()
        binding.orderShimmer.isVisible= true
    }

    private fun clearShimmer(){
        binding.orderShimmer.stopShimmer()
        binding.orderShimmer.isVisible= false
    }

}