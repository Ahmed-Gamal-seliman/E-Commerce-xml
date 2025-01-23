package com.example.e_commerce.product_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentProductDetailsBinding
import com.example.e_commerce.products.ui.ProductsFragmentArgs


class ProductDetailsFragment : Fragment() {

    private lateinit var binding:FragmentProductDetailsBinding
    private val args:ProductDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvDescriptioDetails.text = args.product?.description
        binding.tvProductPrice.text = args.product?.price.toString()
        binding.tvProductTotalPrice.text= args.product?.price.toString()
        binding.tvProductCountAvailable.text= "available: ${args.product?.rating?.count}"

        Glide.with(binding.root)
            .load(args.product?.image)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivProductImage)

        binding.tvProductName.text = args.product?.title
        binding.tvRatingNumber.text = args.product?.rating?.rate.toString()
    }


}