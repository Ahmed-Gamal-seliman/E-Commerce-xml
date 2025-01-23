package com.example.e_commerce.categories.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.models.Category
import com.example.e_commerce.R
import com.example.e_commerce.categories.ui.category_name_adapter.CategoryNameAdapter
import com.example.e_commerce.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private lateinit var categoryNameAdapter: CategoryNameAdapter
    private lateinit var categoryNameList:List<Category>
    private lateinit var binding:FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCategoriesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dummyCateNameData()
        initCategoryNameRecyclerView()

    }



    private fun dummyCateNameData() {
        categoryNameList = listOf(
            Category(name= "Men's fashion"),
            Category(name= "Women's fashion"),
            Category(name= "Sister's fashion"),
            Category(name= "Mother's fashion"),
            Category(name= "Father's fashion"),
            Category(name= "Men's fashion"),
            Category(name= "Women's fashion"),
            Category(name= "Sister's fashion"),
            Category(name= "Mother's fashion"),
            Category(name= "Father's fashion"),
        )
    }

    private fun initCategoryNameRecyclerView() {
        categoryNameAdapter= CategoryNameAdapter(categoryNameList)
        binding.rvCategories.adapter= categoryNameAdapter
    }


}