package com.example.e_commerce.products.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.all_products.Product
import com.example.e_commerce.R
import com.example.e_commerce.databinding.ProductItemBinding

class ProductAdapter(private var productsList:List<Product?>?):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var binding: ProductItemBinding
    var onProductClicked:onProductClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
       binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product= productsList?.get(position)

        if (product != null) {
            binding.cardItem.setOnClickListener{
                onProductClicked?.onProductClick(productsList?.get(position)!!)
            }

            holder.bind(product)

        }
    }

    override fun getItemCount()= productsList?.size ?: 0

    class ProductViewHolder(val bindingViewHolder:ProductItemBinding):ViewHolder(bindingViewHolder.root){
        fun bind(product:Product){

            Glide.with(bindingViewHolder.root)
                .load(product.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(bindingViewHolder.ivProductImage)

            bindingViewHolder.tvProductPrice.text = "$${product.price.toString()}"
            bindingViewHolder.tvProductName.text= product.category
            bindingViewHolder.tvReviewRate.text = "Review (${product.rating?.rate})"
            bindingViewHolder.productCountAvailable.text= "${product.rating?.count} available"
        }
    }

    fun setData(products: List<Product?>?)
    {
        productsList= products
        productsList?.forEach { Log.e("productList","${it}") }
        notifyDataSetChanged()
    }

    fun interface onProductClickListener{
        fun onProductClick(product:Product)
    }
}