package com.example.domain.models.all_products

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Product(

    val image: String? = null,


     val price: @RawValue Any? = null,


    val rating: @RawValue Rating? = null,


    val title: String? = null,


    val category: String? = null,

    val productId:Int?=null,

    val description:String?=null
):Parcelable