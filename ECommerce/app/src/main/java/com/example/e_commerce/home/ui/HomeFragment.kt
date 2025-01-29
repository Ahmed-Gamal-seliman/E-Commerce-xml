package com.example.e_commerce.home.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.example.domain.models.Category
import com.example.e_commerce.MainFragmentDirections


import com.example.e_commerce.R
import com.example.e_commerce.categories.ui.CategoriesFragment
import com.example.e_commerce.categories.ui.category_name_adapter.CategoryNameAdapter
import com.example.e_commerce.databinding.FragmentHomeBinding
import com.example.e_commerce.home.ui.banner.adapter.BannerAdapter
import com.example.e_commerce.home.ui.banner.model.Banner
import com.example.e_commerce.home.ui.category.adapter.CategoryAdapter
import com.example.e_commerce.home.viewmodel.HomeViewModel
import com.example.e_commerce.products.ui.ProductsFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

//   private lateinit var _binding:FragmentHomeBinding
    lateinit var binding:FragmentHomeBinding
    lateinit var bannerAdapter: BannerAdapter
    lateinit var bannerList:List<Banner>
    lateinit var categoryAdapter:CategoryAdapter
    lateinit var categoryList:List<Category>


    val handler:Handler = Handler(Looper.getMainLooper())
    val viewModel: HomeViewModel by viewModels<HomeViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillBannerListData()
        dummyCategoryData()
        showRecyclerViewCategory()
        initBannerViewPager()
        initCategoryRecyclerView()

        autoScrollBanner()




        observeLiveData()

        onGetAllProductsClicked()
        onGetAllOrdersClicked()
        onCategoryItemClicked()
        onShoppingClicked()
//        onSearchClicked()
//        viewModel.getAllProducts()



    }



    private fun onShoppingClicked() {
        binding.layoutHeader.ivCart.setOnClickListener{
            Log.e("shop","clicked")
            val action = MainFragmentDirections.actionMainFragmentToProductsFragment(null)
            findNavController().navigate(action)
        }
    }

    private fun onGetAllOrdersClicked() {
        binding.btnGetAllOrders.setOnClickListener {

            findNavController().navigate(R.id.action_mainFragment_to_ordersFragment)
        }
    }

    private fun autoScrollBanner() {
        val runnable= object: Runnable{
            override fun run() {
//                Log.e("number", binding.viewPager.currentItem.toString())
                if(binding.viewPager.currentItem == 2)
                {
                    binding.viewPager.currentItem=0
                }
                else {
                    binding.viewPager.currentItem = binding.viewPager.currentItem + 1//2
                }


                handler.postDelayed(this,4000)

            }
        }



        handler.postDelayed(runnable,4000)
    }

    private fun onCategoryItemClicked() {
        categoryAdapter.onCategoryClick= CategoryAdapter.OnCategoryClickListener {
            categoryName->

            val action= MainFragmentDirections.actionMainFragmentToProductsFragment(categoryName)


                findNavController().navigate(action)
        }
    }
    private fun onGetAllProductsClicked() {
        binding.btnGetAllProducts.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToProductsFragment(null)
            findNavController().navigate(action)
        }

    }


    private fun observeLiveData() {
        viewModel.categories.observe(viewLifecycleOwner) {categories->
           categoryAdapter.setData(categories?.take(categories.size/2))
            showRecyclerViewCategory()
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            Log.e("isLoading","${isLoading}")
//                showShimmer(isLoading)
        }
        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Log.e("error", "${errorMessage}")

        }


    }



    private fun showRecyclerViewCategory() {

        binding.firstCategoryItemShimmer.apply {
            stopShimmer()
            visibility=View.GONE
        }

        binding.firstRvCategories.visibility= View.VISIBLE

    }




    private fun showShimmer(isLoading: Boolean) {
            binding.firstCategoryItemShimmer.startShimmer()

    }





    private fun initCategoryRecyclerView() {
        categoryAdapter = CategoryAdapter(categoryList)
        binding.firstRvCategories.adapter= categoryAdapter

    }

    private fun dummyCategoryData(){

        categoryList= listOf(
            Category(
                name = "electronics",
                image = "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg"
            ),
            Category(
                name = "jewelery",
                image = "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg"
                ),
            Category(
                name = "men's clothing",
                image = "https://fakestoreapi.com/img/51Y5NI-I5jL._AC_UX679_.jpg"
                ),
            Category(
                name = "women's clothing",
                image = "https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg"
                ),
        )
    }
    private fun fillBannerListData() {
        bannerList = listOf(
            Banner(
                title = "UP TO 25% OFF",
                subtitle = "For all Headphones \n& AirPods",
                image = R.drawable.first_banner,
                buttonBackground = R.color.blue,
                titleColor = R.color.blue,
                subtitleColor = R.color.blue,
                textButtonColor = R.color.white
            ),
            Banner(
                title = "UP TO 30% OFF",
                subtitle = "For all Makeup\n& Skincare",
                image = R.drawable.second_banner,
                buttonBackground = R.color.blue,
                titleColor = R.color.white,
                subtitleColor = R.color.white,
                textButtonColor = R.color.white
            ),
            Banner(
                title = "UP TO 20% OFF",
                subtitle = "For Laptops\n& Mobiles",
                image = R.drawable.third_banner,
                buttonBackground = R.color.white,
                titleColor = R.color.blue,
                subtitleColor = R.color.blue,
                textButtonColor = R.color.blue
            ),


        )
    }

    private fun initBannerViewPager() {
        bannerAdapter = BannerAdapter(bannerList)
        binding.viewPager.adapter = bannerAdapter
    }


}