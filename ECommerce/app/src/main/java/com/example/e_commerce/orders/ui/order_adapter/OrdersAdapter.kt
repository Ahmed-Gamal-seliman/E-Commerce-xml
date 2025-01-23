package com.example.e_commerce.orders.ui.order_adapter

import android.provider.ContactsContract.Data
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.order.CartItemsItem
import com.example.domain.models.order.DataItem
import com.example.e_commerce.R
import com.example.e_commerce.databinding.OrderItemBinding

class OrdersAdapter(var orderList:List<CartItemsItem?>?):RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {
    private lateinit var binding:OrderItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        binding = OrderItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val orderItem= orderList?.get(position)
        holder.bind(orderItem)
    }

    override fun getItemCount()= orderList?.size ?: 0

    class OrderViewHolder(val bindingViewHolder:OrderItemBinding):ViewHolder(bindingViewHolder.root)
    {
        fun bind(orderItem:CartItemsItem?)
        {

                Glide.with(bindingViewHolder.root)
                    .load(orderItem?.product?.imageCover)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(bindingViewHolder.ivOrderImage)



            bindingViewHolder.tvOrderName.text = orderItem?.product?.title

            bindingViewHolder.tvOrderPrice.text= "EGP ${orderItem?.price.toString()}"

            bindingViewHolder.tvCount.text = "count: ${orderItem?.count.toString()}"
            bindingViewHolder.tvBrandName.text = "brand: ${orderItem?.product?.brand?.name}"



        }
    }

fun setData(orders:List<CartItemsItem?>?)
{
    orderList = orders
    notifyDataSetChanged()
}

}