package com.example.e_commerce.categories.ui.category_name_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domain.models.Category
import com.example.e_commerce.databinding.CategoryItemBinding
import com.example.e_commerce.databinding.CustomCategoryShapeBinding

class CategoryNameAdapter(private val categoriesNameList:List<Category>):RecyclerView.Adapter<CategoryNameAdapter.CategoryNameViewHolder>() {
    private lateinit var binding:CustomCategoryShapeBinding
    var onCategoryClick:OnCategoryClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNameViewHolder {
        binding = CustomCategoryShapeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryNameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNameViewHolder, position: Int) {
        val categoryName = categoriesNameList[position]
        holder.bind(categoryName)
        onCategoryClick?.onCategoryClicked(categoriesNameList[position].name ?: "")
    }

    override fun getItemCount()= categoriesNameList.size

    class CategoryNameViewHolder(val bindingViewHolder: CustomCategoryShapeBinding):ViewHolder(bindingViewHolder.root){
        fun bind(categoryName:Category)
        {
            bindingViewHolder.tvCategoryName.text= categoryName.name
        }
    }

    fun interface OnCategoryClickListener{
        fun onCategoryClicked(categoryName:String)
    }
}