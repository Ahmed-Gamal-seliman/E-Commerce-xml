package com.example.e_commerce.home.ui.category.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.domain.models.Category
import com.example.e_commerce.R
import com.example.e_commerce.databinding.CategoryItemBinding


class CategoryAdapter(
    private var categoriesList:List<Category?>?
):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    lateinit var viewBinding:CategoryItemBinding
     var onCategoryClick: OnCategoryClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        viewBinding = CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoriesList?.get(position)

        holder.bind(category,position)
        viewBinding.categoryItem.setOnClickListener{
            onCategoryClick?.onCategoryClick(categoriesList?.get(position)?.name ?: "jewelery")
        }


    }

    override fun getItemCount() = categoriesList?.size ?: 0

     class CategoryViewHolder(val bindingViewHolder: CategoryItemBinding):ViewHolder(bindingViewHolder.root){
        fun bind(category:Category?, position:Int)
        {
            Glide.with(bindingViewHolder.root)
                .load(category?.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(bindingViewHolder.circleIvCateogry)
//            bindingViewHolder.circleIvCateogry.setImageURI()
            bindingViewHolder.tvCategoryTitle.text = category?.name
        }
    }

    fun setData(categories:List<Category?>?)
    {
        categoriesList = categories
        notifyDataSetChanged()
    }




    fun interface OnCategoryClickListener{
        fun onCategoryClick(categoryName:String)
    }
}
