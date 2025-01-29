package com.example.e_commerce.product_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerce.R
import com.example.e_commerce.databinding.FragmentOrderDetailsBinding


class OrderDetailsFragment : Fragment() {

    private lateinit var binding:FragmentOrderDetailsBinding
    private val args:OrderDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOrderDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemData()
    }

    private fun itemData() {
        //        binding.tvDescriptioDetails.text = args.order?.product?.category?.
        binding.tvProductPrice.text = args.order?.price.toString()
        binding.tvProductTotalPrice.text = args.order?.price.toString()
        binding.tvProductCountAvailable.text = "available: ${args.order?.count}"

        Glide.with(binding.root)
            .load(args.order?.product?.imageCover)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.ivProductImage)

        binding.tvProductName.text = args.order?.product?.title
        binding.tvRatingNumber.text = args.order?.product?.ratingsAverage?.toString()
    }


}